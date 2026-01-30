package com.example.myfitapp.Screens

import android.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.myfitapp.db.WorkoutDatabase
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgressScreen(navController: NavController) {
    val context = LocalContext.current
    val db = WorkoutDatabase.getDatabase(context)
    val dao = db.workoutDao()
    val coroutineScope = rememberCoroutineScope()

    var exerciseList by remember { mutableStateOf(listOf<String>()) }
    var selectedExercise by remember { mutableStateOf<String?>(null) }
    var progressData by remember { mutableStateOf(listOf<Pair<String, Float>>()) }

    // Загрузка названий упражнений
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            val names = dao.getAllWorkoutTitles() // должен возвращать List<String>
            exerciseList = names.distinct()
        }
    }

    Column(Modifier.padding(48.dp)) {
        Text("Прогресс по упражнениям", style = MaterialTheme.typography.headlineSmall)

        Spacer(Modifier.height(16.dp))

        // Выпадающий список выбора упражнения
        var expanded by remember { mutableStateOf(false) }

        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
            TextField(
                value = selectedExercise ?: "",
                onValueChange = {},
                readOnly = true,
                label = { Text("Выберите упражнение") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor().fillMaxWidth()
            )

            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                exerciseList.forEach { name ->
                    DropdownMenuItem(text = { Text(name) }, onClick = {
                        selectedExercise = name
                        expanded = false

                        coroutineScope.launch {
                            val stats = dao.getWorkoutStatsByTitle(name)
                            progressData = stats.map { it.date to it.maxWeight }
                        }
                    })
                }
            }
        }

        Spacer(Modifier.height(24.dp))

        // График
        if (progressData.isNotEmpty()) {
            AndroidView(
                modifier = Modifier.fillMaxWidth().height(300.dp),
                factory = { ctx ->
                    LineChart(ctx).apply {
                        description = Description().apply { text = "Вес по датам" }
                        setTouchEnabled(true)
                        setPinchZoom(true)
                        setBackgroundColor(Color.WHITE)
                    }
                },
                update = { chart ->
                    val entries = progressData.mapIndexed { index, data ->
                        Entry(index.toFloat(), data.second)
                    }
                    val dataSet = LineDataSet(entries, selectedExercise).apply {
                        color = Color.BLUE
                        valueTextColor = Color.BLACK
                        lineWidth = 2f
                        circleRadius = 4f
                    }
                    chart.data = LineData(dataSet)
                    chart.invalidate()
                }
            )
        }
    }
}

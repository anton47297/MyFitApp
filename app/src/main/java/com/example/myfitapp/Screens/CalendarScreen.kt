package com.example.myfitapp.Screens

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myfitapp.Dao.WorkoutDao
import com.example.myfitapp.db.WorkoutDatabase
import com.example.myfitapp.Entity.Workout
import com.example.myfitapp.Entity.WorkoutSet
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun CalendarScreen(navController: NavController) {
    val context = LocalContext.current
    val workoutDao = WorkoutDatabase.getDatabase(context).workoutDao()
    val coroutineScope = rememberCoroutineScope()

    var selectedDate by remember { mutableStateOf("") }
    var workoutTitle by remember { mutableStateOf("") }
    var workoutDescription by remember { mutableStateOf("") }
    var savedWorkouts by remember { mutableStateOf(listOf<Workout>()) }
    var workoutSets by remember { mutableStateOf(mapOf<Int, List<WorkoutSet>>()) }

    var isEditing by remember { mutableStateOf(false) }
    var editingWorkout by remember { mutableStateOf<Workout?>(null) }

    // Для добавления подходов
    var weight by remember { mutableStateOf("") }
    var reps by remember { mutableStateOf("") }
    var currentWorkoutId by remember { mutableStateOf<Int?>(null) }

    val calendar = Calendar.getInstance()

    fun loadWorkoutsAndSets() {
        coroutineScope.launch {
            val workouts = workoutDao.getAllWorkouts()
            val setsMap = mutableMapOf<Int, List<WorkoutSet>>()
            workouts.forEach { workout ->
                val sets = workoutDao.getSetsForWorkout(workout.id)
                setsMap[workout.id] = sets
            }
            savedWorkouts = workouts
            workoutSets = setsMap
        }
    }

    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            selectedDate = "$dayOfMonth/${month + 1}/$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    LaunchedEffect(Unit) {
        loadWorkoutsAndSets()
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(48.dp)) {

        Text(
            text = if (isEditing) "Редактировать тренировку" else "Добавить тренировку",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(onClick = { datePickerDialog.show() }, modifier = Modifier.fillMaxWidth()) {
            Text("Выбрать дату")
        }

        if (selectedDate.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text("Выбранная дата: $selectedDate")
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = workoutTitle,
                onValueChange = { workoutTitle = it },
                label = { Text("Название тренировки") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = workoutDescription,
                onValueChange = { workoutDescription = it },
                label = { Text("Описание") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (workoutTitle.isNotBlank()) {
                        val workout = Workout(
                            id = editingWorkout?.id ?: 0,
                            date = selectedDate,
                            title = workoutTitle,
                            description = workoutDescription
                        )
                        coroutineScope.launch {
                            val workoutId = if (isEditing && editingWorkout != null) {
                                workoutDao.update(workout)
                                workout.id
                            } else {
                                workoutDao.insert(workout) // просто вставляем, не сохраняем ID
                                null
                            }

                            selectedDate = ""
                            workoutTitle = ""
                            workoutDescription = ""
                            isEditing = false
                            editingWorkout = null
                            currentWorkoutId = null // не отображаем форму подходов после добавления

                            loadWorkoutsAndSets()
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (isEditing) "Сохранить" else "Добавить тренировку")
            }
        }

        if (currentWorkoutId != null) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Добавить подход", style = MaterialTheme.typography.titleMedium)

            OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text("Вес (кг)") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = reps,
                onValueChange = { reps = it },
                label = { Text("Повторения") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = {
                if (weight.isNotEmpty() && reps.isNotEmpty()) {
                    coroutineScope.launch {
                        workoutDao.insertSet(
                            WorkoutSet(
                                workoutId = currentWorkoutId!!,
                                weight = weight.toFloat(),
                                reps = reps.toInt()
                            )
                        )
                        weight = ""
                        reps = ""
                        loadWorkoutsAndSets()
                    }
                }
            }, modifier = Modifier.padding(top = 8.dp)) {
                Text("Сохранить подход")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Список тренировок", style = MaterialTheme.typography.headlineSmall)

        LazyColumn {
            items(savedWorkouts) { workout ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("📅 ${workout.date} — ${workout.title}")
                        if (workout.description.isNotBlank()) {
                            Text("Описание: ${workout.description}")
                        }

                        val sets = workoutSets[workout.id] ?: emptyList()
                        if (sets.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("Подходы:")
                            sets.forEachIndexed { index, set ->
                                Text("• ${index + 1}: ${set.weight} кг × ${set.reps} раз")
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            TextButton(onClick = {
                                selectedDate = workout.date
                                workoutTitle = workout.title
                                workoutDescription = workout.description
                                isEditing = true
                                editingWorkout = workout
                                currentWorkoutId = workout.id
                            }) {
                                Text("✏️")
                            }

                            TextButton(onClick = {
                                coroutineScope.launch {
                                    workoutDao.delete(workout)
                                    loadWorkoutsAndSets()
                                }
                            }) {
                                Text("🗑️")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCalendarScreen() {
    CalendarScreen(navController = rememberNavController())
}

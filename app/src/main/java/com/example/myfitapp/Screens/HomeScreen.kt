package com.example.myfitapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.*
import com.example.myfitapp.R
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(navController: NavController) {
    val customBold = FontFamily(Font(R.font.bold, FontWeight.Bold))
    val customNormal = FontFamily(Font(R.font.regular, FontWeight.Normal))

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFCCC2DC), Color(0xFF9575CD))
                )
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            LottieAnimation(
                composition = composition,
                progress = progress,
                modifier = Modifier.size(220.dp)
            )

            Text(
                text = "Добро пожаловать",
                fontSize = 28.sp,
                fontFamily = customBold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge.copy(
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(2f, 2f),
                        blurRadius = 8f
                    )
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            ActionButton(
                text = "Показать тренировки",
                icon = Icons.Default.FitnessCenter,
                onClick = { navController.navigate("workoutList") },
                customFont = customNormal
            )

            ActionButton(
                text = "Календарь тренировок",
                icon = Icons.Default.Event,
                onClick = { navController.navigate("calendarScreen") },
                customFont = customNormal
            )

            ActionButton(
                text = "Рекомендации по питанию",
                icon = Icons.Default.Restaurant,
                onClick = { navController.navigate("dietList") },
                customFont = customNormal
            )

            ActionButton(
                text = "Прогресс тренировок",
                icon = Icons.Default.TrendingUp,
                onClick = { navController.navigate("progressScreen") },
                customFont = customNormal
            )
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
    customFont: FontFamily
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFEDE7F6),
            contentColor = Color(0xFF4A148C)
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = customFont
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}

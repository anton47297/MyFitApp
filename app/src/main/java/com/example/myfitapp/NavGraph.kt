package com.example.myfitapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myfitapp.Screens.HomeScreen
import com.example.myfitapp.Screens.WorkoutDetailScreen
import com.example.myfitapp.Screens.WorkoutListScreen
import com.example.myfitapp.Screens.DietListScreen
import com.example.myfitapp.Screens.CalendarScreen
import com.example.myfitapp.Screens.ProgressScreen


@Composable
fun NavGraph(startDestination: String = "home") {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable("home") { HomeScreen(navController) }

        //workout
        composable("workoutList") { WorkoutListScreen(navController) }
        composable(
            "workoutDetail/{workout}",
            arguments = listOf(navArgument("workout") { type = NavType.StringType })
        ) { backStackEntry ->
            WorkoutDetailScreen(backStackEntry.arguments?.getString("workout") ?: "")
        }

        composable("calendarScreen") {
            CalendarScreen(navController)
        }

        //diet
        composable("dietList") { DietListScreen(navController) }

        // progress
        composable("progressScreen") {
            ProgressScreen(navController)
        }
    }
}
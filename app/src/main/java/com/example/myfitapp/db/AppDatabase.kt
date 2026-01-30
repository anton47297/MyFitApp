package com.example.myfitapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myfitapp.Dao.WorkoutDao
import com.example.myfitapp.Entity.Workout
import com.example.myfitapp.Entity.WorkoutSet

@Database(entities = [Workout::class, WorkoutSet::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao
}
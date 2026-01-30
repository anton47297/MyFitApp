package com.example.myfitapp.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "workout_sets",
    foreignKeys = [ForeignKey(
        entity = Workout::class,
        parentColumns = ["id"],
        childColumns = ["workoutId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class WorkoutSet(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val workoutId: Int,
    val weight: Float,
    val reps: Int
)

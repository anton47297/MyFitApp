package com.example.myfitapp.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import com.example.myfitapp.Entity.Workout
import com.example.myfitapp.Entity.WorkoutSet
import com.example.myfitapp.Entity.WorkoutStat


@Dao
interface WorkoutDao {
    @Insert
    suspend fun insert(workout: Workout): Long

    @Update
    suspend fun update(workout: Workout)

    @Delete
    suspend fun delete(workout: Workout)

    @Query("SELECT * FROM workouts")
    suspend fun getAllWorkouts(): List<Workout>

    @Insert
    suspend fun insertSet(set: WorkoutSet)

    @Query("SELECT * FROM workout_sets WHERE workoutId = :workoutId")
    suspend fun getSetsForWorkout(workoutId: Int): List<WorkoutSet>

    @Delete
    suspend fun deleteSet(set: WorkoutSet)

    @Query("DELETE FROM workout_sets WHERE workoutId = :workoutId")
    suspend fun deleteSetsByWorkoutId(workoutId: Int)

    @Query("SELECT DISTINCT title FROM workouts")
    suspend fun getAllWorkoutTitles(): List<String>

    @Query("""
    SELECT w.date, MAX(s.weight) as maxWeight
    FROM workouts w 
    JOIN workout_sets s ON w.id = s.workoutId
    WHERE w.title = :title
    GROUP BY w.date
    ORDER BY w.date ASC
""")
    suspend fun getWorkoutStatsByTitle(title: String): List<WorkoutStat>
}

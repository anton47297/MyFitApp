package com.example.myfitapp.ViewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel

data class DietDay(
    val dayOfWeek: String,
    val dietPlan: String,
    val isCompleted: Boolean
)

class DietListViewModel : ViewModel() {

    private val _dietGroup = mutableStateListOf(
        DietDay("Понедельник", "План питания 1", false),
        DietDay("Вторник", "План питания 2", false),
        DietDay("Среда", "План питания 3", false),
        DietDay("Четверг", "План питания 4", false),
        DietDay("Пятница", "План питания 5", false),
        DietDay("Суббота", "План питания 6", false),
        DietDay("Воскресенье", "План питания 7", false)
    )

    val dietGroups: SnapshotStateList<DietDay>
        get() = _dietGroup

    // Метод для изменения состояния выполнения диеты
    fun toggleDietCompletion(dietDay: DietDay) {
        val index = _dietGroup.indexOf(dietDay)
        if (index != -1) {
            val updatedDietDay = dietDay.copy(isCompleted = !dietDay.isCompleted)
            _dietGroup[index] = updatedDietDay
        }
    }
}

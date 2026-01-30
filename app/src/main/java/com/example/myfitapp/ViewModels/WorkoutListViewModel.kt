package com.example.myfitapp.ViewModels

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

class WorkoutListViewModel : ViewModel() {
    // LiveData or State to hold muscle groups
    private val _muscleGroups = mutableStateListOf(
        "Грудь" to "Основные мышцы: большая и малая грудные. Функция: Выталкивает руку перед туловищем.",
        "Плечи" to "Основные мышцы: дельтовидные. Функция: Отводит руку от туловища и вращает ее.",
        "Трицепс" to "Основные мышцы: Трехглавая мышца плеча. Функция: Выпрямляет руку в локте.",
        "Спина" to "Основные мышцы: Широчайшая мышца спины, ромбовидные и трапециевидные мышцы. Функция: Отводит руку вниз по направлению к туловищу.",
        "Бицепс" to "Основные мышцы: Двуглавая мышца плеча. Функция: Сгибает руку в локте.",
        "Ноги" to "Основные мышцы: четырехглавая мышца, подколенные сухожилия, икры. Функция: Поддерживает вес тела и позволяет двигаться."
    )

    val muscleGroups: SnapshotStateList<Pair<String, String>>
        get() = _muscleGroups
}

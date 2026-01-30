package com.example.myfitapp.Repository

class WorkoutRepository {
    fun getWorkoutDetails(workout: String): List<Pair<String, String>> {
        return when (workout) {
            "Грудь" -> listOf(
                "1. Жим лежа - 4 подхода по 8-12 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/benchpress.mp4",
                "2. Жим гантелей в наклоне - 4 подхода по 8-12 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/incline.mp4",
                "3. Упражнения на тросах - 3 подхода по 12-15 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/tros.mp4",
                "4. Разведение гантелей - 3 подхода по 12-15 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/dumbellflyes.mp4",
                "5. Тренажер для жима от груди - 4 подхода по 8-12 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/cableflyes.mp4",
                "6. Отжимания - 4 подхода по 15-20 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/puchups.mp4",
                "7. Наклонный жим лежа - 4 подхода по 8-12 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/benchpress_icline.mp4",
                "8. Тренажер для грудной клетки - 3 подхода по 12-15 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/baterfly.mp4"
            )

            "Плечи" -> listOf(
                "1. Тренажер для жима сидя - 3 подхода по 12-15 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/incpress.mp4",
                "2. Жим гантелей сидя - 4 подхода по 8-12 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/head.mp4",
                "3. Махи гантелей в стороны - 4 подхода по 12-15 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/later.mp4",
                "4. Подъемы вперед - 3 подхода по 12-15 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/frontal.mp4",
                "5. Жим Арнольда - 4 подхода по 8-12 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/arnold_press.mp4",
            )

            "Трицепс" -> listOf(
                "1. Отжимания на трицепс - 4 подхода по 8-12 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/triceps/dips.mp4",
                "2. Отжимания на трицепс - 4 подхода по 12-15 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/triceps/pushdowns.mp4",
                "3. Разгибание трицепса над головой - 3 подхода по 12-15 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/triceps/extension.mp4",
                "4. Жим лежа узким хватом - 4 подхода по 8-12 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/triceps/closegrip.mp4",
                "5. Сокрушители черепов - 4 подхода по 8-12 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/triceps/skullcrushers.mp4",
                "6. Отдачи от гантелей - 3 подхода по 12-15 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/triceps/kickbck.mp4",
            )

            "Спина" -> listOf(
                "1. Тяга лежа - 4 подхода по 8-12 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/latpulldown.mp4",
                "2. Тренажер для сидения в ряд - 3 подхода по 8-12 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/seatedrow.mp4 ",
                "3. Т-образный тренажер - 3 подхода по 8-12 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/tbarrow.mp4 ",
                "4. Задняя часть Маховый тренажер для дельт - 3 подхода по 8-12 повторений " to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/reardelt.mp4 ",
                "5. Жим плечами с гантелями - 3 подхода по 8-12 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/shrugs.mp4",
                "6. Наклоны вперед - 4 подхода по 8-12 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/bentoverrows.mp4 ",
                "7. Становая тяга - 4 подхода по 8-12 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/deadlift.mp4 ",
                "8. Подтягивания - 4 подхода из 8-12 повторений " to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/pullups.mp4 ",
            )

            "Бицепс" -> listOf(
                "1. Сгибания штанги - 4 подхода по 8-12 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/biceps/barbellcurls.mp4",
                "2. Сгибания молота - 4 подхода по 12-15 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/biceps/hamer.mp4",
                "3. Сгибания концентрации - 3 подхода по 12-15 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/biceps/concen.mp4 ",
                "4. Завитки проповедника - 4 набора 8-12 повторений " to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/biceps/preacher.mp4 ",
                "5. Сгибания тросом - 4 подхода по 8-12 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/biceps/cable.mp4",
                "6. Сгибания пауком - 3 подхода по 12-15 повторений" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/biceps/spider.mp4",
            )

            "Ноги" -> listOf(
                "1. Приседания - 4 подхода по 8-12 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/squtleg.mp4",
                "2. Жим ногами - 4 подхода по 12-15 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/leg_press.mp4",
                "3. Сгибания ног - 4 подхода по 12-15 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/leg_curls.mp4",
                "4. Разгибания ног - 4 подхода по 12-15 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/ext.mp4",
                "5. Подъемы икр - 4 подхода по 15-20 повторений" to "https://github.com/anton47297/bondarenkoaiLab/raw/refs/heads/main/videos/calf.mp4",
            )

            else -> emptyList()
        }
    }
}


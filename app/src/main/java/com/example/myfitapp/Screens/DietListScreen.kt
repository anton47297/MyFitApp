package com.example.myfitapp.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfitapp.R

@Composable
fun DietListScreen(navController: NavController) {
    val customFontRegular = FontFamily(Font(R.font.regular, FontWeight.Normal))
    val customFontBold = FontFamily(Font(R.font.bold, FontWeight.Normal))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Рекомендации по питанию на каждый день",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.tertiary,
            fontFamily = customFontBold,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding(),
                bottom = 8.dp
            )
        )

        Text(
            text = "Не забудьте ежедневно принимать как минимум 1,5-2 грамма белка на 1кг массы вашего тела, чтобы добиться быстрого увеличения, например, если ваш вес составляет 50 кг. " +
                    "\n\n~ 50 х 1,5 = 75 г (минимум)\n~ 50 х 2,0 = 100 г (максимум)" +
                    "\n\nТакже важно следить за поступлением жиров и углеводов:" +
                    "\n\nЖиры: рекомендуется употреблять около 0,8–1 грамма жиров на 1 кг массы тела. " +
                    "\nЖиры необходимы для гормонального баланса и правильной работы организма." +
                    "\n\nУглеводы: основной источник энергии. При наборе массы их количество должно составлять 4–6 граммов на 1 кг массы тела, в зависимости от ваших целей и активности." +
                    "\n\nБаланс между белками, жирами и углеводами играет ключевую роль в достижении желаемого результата!",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = customFontRegular
        )
    }
}

@Preview(showBackground = true, name = "DietListScreen Preview")
@Composable
fun DietListScreenPreview() {
    val navController = rememberNavController()
    MaterialTheme {
        DietListScreen(navController = navController)
    }
}

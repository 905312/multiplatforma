package org.example.marafon

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MoreInfoScreen(navigator: Navigator) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Подробная информация",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        
        // Кнопка "Marathon Skills 2016"
        Button(
            onClick = { navigator.navigateTo(Screen.ABOUT_MARATHON) },
            modifier = Modifier.fillMaxWidth().height(70.dp).padding(vertical = 8.dp, horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "Marathon Skills 2016",
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
        }
        
        // Кнопка "Насколько долгий марафон"
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(70.dp).padding(vertical = 8.dp, horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "Насколько долгий марафон",
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
        }
        
        // Кнопка "Предыдущие результаты"
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(70.dp).padding(vertical = 8.dp, horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "Предыдущие результаты",
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
        }
        
        // Кнопка "Список благотворительных организаций"
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(70.dp).padding(vertical = 8.dp, horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "Список благотворительных организаций",
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
        }
        
        // Кнопка "BMI калькулятор"
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(70.dp).padding(vertical = 8.dp, horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "BMI калькулятор",
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
        }
        
        // Кнопка "BMR калькулятор"
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(70.dp).padding(vertical = 8.dp, horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "BMR калькулятор",
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
        }
    }
}

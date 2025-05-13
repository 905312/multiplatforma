package org.example.marafon

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
fun AboutMarathonScreen(navigator: Navigator) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Информация о Marathon Skills 2016",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Левая колонка - карта и фотографии
            Column(
                modifier = Modifier.weight(1f).padding(end = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Карта марафона
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .background(Color.LightGray)
                        .border(1.dp, Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Карта марафона\n(нажмите чтобы открыть интерактивную карту)",
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp
                    )
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Сетка фотографий
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Фото 1
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(80.dp)
                            .padding(end = 4.dp)
                            .background(Color.LightGray)
                            .border(1.dp, Color.Gray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Photo")
                    }
                    
                    // Фото 2
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(80.dp)
                            .padding(start = 4.dp)
                            .background(Color.LightGray)
                            .border(1.dp, Color.Gray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Photo")
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Еще фотографии
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Фото 3
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(80.dp)
                            .padding(end = 4.dp)
                            .background(Color.LightGray)
                            .border(1.dp, Color.Gray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Photo")
                    }
                    
                    // Фото 4
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(80.dp)
                            .padding(start = 4.dp)
                            .background(Color.LightGray)
                            .border(1.dp, Color.Gray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Photo")
                    }
                }
            }
            
            // Правая колонка - описание
            Column(
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            ) {
                Text(
                    text = "Информация о Навыках Марафона 2016 пойдет сюда. Информация может покрыть расположение, время, расстояние, рекордные времена, достопримечательности, и т.д.",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Text(
                    text = "Дополнительные сведения. Дополнительные сведения. Дополнительные сведения. Дополнительные сведения. Дополнительные сведения. Дополнительные сведения. Дополнительные сведения. Дополнительные сведения.",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Text(
                    text = "Дополнительные сведения. Дополнительные сведения. Дополнительные сведения. Дополнительные сведения. Дополнительные сведения. Дополнительные сведения. Дополнительные сведения. Дополнительные сведения.",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Text(
                    text = "Дополнительные сведения. Дополнительные сведения. Дополнительные сведения. Дополнительные сведения.",
                    fontSize = 14.sp
                )
            }
        }
    }
}

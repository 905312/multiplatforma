package org.example.marafon

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.window.Dialog

@Composable
fun EventRegistrationScreen(navigator: Navigator) {
    var option42km by remember { mutableStateOf(true) }
    var option21km by remember { mutableStateOf(false) }
    var option5km by remember { mutableStateOf(true) }
    var amount by remember { mutableStateOf("") }
    var showSponsorDialog by remember { mutableStateOf(false) }
    
    val scrollState = rememberScrollState()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Регистрация на марафон",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        
        Text(
            text = "Пожалуйста заполните всю информацию, чтобы зарегистрироваться на Skills Marathon",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Вид марафона",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 16.dp)
            )
            
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = option42km,
                        onCheckedChange = { option42km = it },
                        colors = CheckboxDefaults.colors(checkedColor = Color.DarkGray)
                    )
                    Text("42km Полный марафон")
                }
                
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = option21km,
                        onCheckedChange = { option21km = it },
                        colors = CheckboxDefaults.colors(checkedColor = Color.DarkGray)
                    )
                    Text("21km Полумарафон")
                }
                
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = option5km,
                        onCheckedChange = { option5km = it },
                        colors = CheckboxDefaults.colors(checkedColor = Color.DarkGray)
                    )
                    Text("5km Малая дистанция")
                }
            }
        }
        
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Детали спонсорства",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Text("Взнос")
                
                OutlinedTextField(
                    value = amount,
                    onValueChange = { amount = it },
                    label = { Text("Сумма взноса:") },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                )
            }
            
            Column(
                modifier = Modifier.weight(1f).padding(start = 16.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Варианты комплектов",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Text("Номер бегуна +")
                Text("Вариант A + бутылка воды.")
                Text("Вариант B + сувенирный буклет.")
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "Регистрационный взнос",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                )
                
                Text(
                    text = "$185",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { showSponsorDialog = true },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text("Регистрация")
            }
            
            Button(
                onClick = { navigator.goBack() },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text("Отмена")
            }
        }
    }
    
    if (showSponsorDialog) {
        Dialog(onDismissRequest = { showSponsorDialog = false }) {
            Card(
                modifier = Modifier.fillMaxWidth(0.8f),
                shape = RoundedCornerShape(4.dp),
                backgroundColor = Color.White,
                elevation = 8.dp
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.padding(vertical = 24.dp, horizontal = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Наименование спонсора",
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .background(color = Color(0xFFFFD700), shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Logo",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Text(
                            text = """Здесь указывается описание благотворительной организации.
Должна быть обеспечена возможность просмотра большого количества информации в данном окне""",
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                    
                    // Кнопка закрытия в правом верхнем углу (красный X)
                    IconButton(
                        onClick = { showSponsorDialog = false },
                        modifier = Modifier.align(Alignment.TopEnd).padding(4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(Color.Red, shape = RoundedCornerShape(4.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "×",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

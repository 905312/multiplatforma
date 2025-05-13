package org.example.marafon

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun SponsorRunnerScreen(navigator: Navigator) {
    var name by remember { mutableStateOf("") }
    var runner by remember { mutableStateOf("") }
    var card by remember { mutableStateOf("") }
    var cardNumber by remember { mutableStateOf("") }
    var expiry by remember { mutableStateOf("") }
    var cvc by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("50") }
    var showSponsorDialog by remember { mutableStateOf(false) }
    
    // Состояния для отображения ошибок валидации
    var showNameError by remember { mutableStateOf(false) }
    var showRunnerError by remember { mutableStateOf(false) }
    var showCardError by remember { mutableStateOf(false) }
    var showCardNumberError by remember { mutableStateOf(false) }
    
    val scrollState = rememberScrollState()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Спонсор бегуна",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        
        Text(
            text = "Пожалуйста выберите бегуна, которого вы хотели бы спонсировать и сумму, которую вы хотели бы пожертвовать на его благотворительность",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Информация о спонсоре",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(2f).padding(end = 16.dp)
            )
            
            Text(
                text = "Благотворительность",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
        }
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Column(modifier = Modifier.weight(2f).padding(end = 16.dp)) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { 
                        name = it 
                        showNameError = false
                    },
                    label = { Text("Ваше имя:") },
                    isError = showNameError,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                )
                
                if (showNameError) {
                    Text(
                        "Это поле обязательно для заполнения",
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                
                OutlinedTextField(
                    value = runner,
                    onValueChange = { 
                        runner = it 
                        showRunnerError = false
                    },
                    label = { Text("Бегун:") },
                    isError = showRunnerError,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                )
                
                if (showRunnerError) {
                    Text(
                        "Это поле обязательно для заполнения",
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                
                OutlinedTextField(
                    value = card,
                    onValueChange = { 
                        card = it 
                        showCardError = false
                    },
                    label = { Text("Карта:") },
                    isError = showCardError,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                )
                
                if (showCardError) {
                    Text(
                        "Это поле обязательно для заполнения",
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedTextField(
                        value = cardNumber,
                        onValueChange = { 
                            cardNumber = it 
                            showCardNumberError = false
                        },
                        label = { Text("Номер карты#:") },
                        isError = showCardNumberError,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f).padding(end = 4.dp, top = 4.dp, bottom = 4.dp)
                    )
                    
                }
                
                if (showCardNumberError) {
                    Text(
                        "Это поле обязательно для заполнения",
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedTextField(
                        value = expiry,
                        onValueChange = { expiry = it },
                        label = { Text("Срок действия:") },
                        modifier = Modifier.weight(1f).padding(end = 4.dp, top = 4.dp, bottom = 4.dp)
                    )
                    
                    OutlinedTextField(
                        value = cvc,
                        onValueChange = { cvc = it },
                        label = { Text("CVC:") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.width(100.dp).padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
                    )
                }
            }
            
            Box(
                modifier = Modifier.weight(1f).padding(start = 8.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Информация",
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Сумма пожертвования",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { 
                    if (amount.toIntOrNull() != null && amount.toInt() > 0) {
                        amount = (amount.toInt() - 10).coerceAtLeast(10).toString()
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text("-")
            }
            
            Text(
                text = "$$amount",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            
            Button(
                onClick = { 
                    if (amount.toIntOrNull() != null) {
                        amount = (amount.toInt() + 10).toString()
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text("+")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { 
                    // Проверяем заполнение обязательных полей
                    showNameError = name.isEmpty()
                    showRunnerError = runner.isEmpty()
                    showCardError = card.isEmpty()
                    showCardNumberError = cardNumber.isEmpty()
                    
                    // Переходим дальше только если все поля заполнены
                    if (!showNameError && !showRunnerError && !showCardError && !showCardNumberError) {
                        // Показываем диалоговое окно спонсора
                        showSponsorDialog = true
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text("Заплатить")
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
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Наименование спонсора",
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .background(color = Color(0xFFFFD700), shape = CircleShape)
                            .align(Alignment.CenterHorizontally),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Logo",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "Здесь указывается описание благотворительной организации.\nДолжна быть обеспечена возможность просмотра большого количества информации в данном окне",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    
                    Button(
                        onClick = { 
                            showSponsorDialog = false
                            // Передаем выбранную сумму пожертвования
                            navigator.navigateTo(
                                Screen.SPONSORSHIP_CONFIRMATION,
                                mapOf(
                                    "donationAmount" to amount,
                                    "runnerName" to (if (runner.isNotEmpty()) runner else "Иван Прудов(204)"),
                                    "charityName" to "Фонд кошек"
                                )
                            )
                        },
                        modifier = Modifier.align(Alignment.End).padding(top = 8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
                    ) {
                        Text("×", color = Color.White, fontSize = 20.sp)
                    }
                }
            }
        }
    }
}

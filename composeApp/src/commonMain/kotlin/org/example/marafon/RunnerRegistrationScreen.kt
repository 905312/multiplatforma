package org.example.marafon

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

// Data class to hold form state
data class RunnerFormState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val gender: String = "Мужской",
    val birthDate: String = "1978-07-16",
    val country: String = "Russia",
    val photoPath: String = "Photo_logo.jpg"
)

// Data class to track validation errors
data class ValidationErrors(
    val email: Boolean = false,
    val password: Boolean = false,
    val confirmPassword: Boolean = false,
    val passwordMatch: Boolean = false,
    val firstName: Boolean = false,
    val lastName: Boolean = false
)

// Reusable TextField component with error handling
@Composable
fun FormTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isError: Boolean = false,
    errorText: String = "Это поле обязательно для заполнения",
    isPassword: Boolean = false,
    modifier: Modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
    readOnly: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            isError = isError,
            modifier = modifier,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = if (isPassword) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions.Default,
            readOnly = readOnly,
            trailingIcon = trailingIcon
        )
        
        if (isError) {
            Text(
                text = errorText,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

// Reusable Dropdown component
@Composable
fun FormDropdown(
    value: String,
    options: List<String>,
    isExpanded: Boolean,
    onExpandChange: (Boolean) -> Unit,
    onOptionSelected: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    Row(
        modifier = modifier.padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, modifier = Modifier.padding(end = 8.dp))
        
        Box(modifier = Modifier.weight(1f)) {
            OutlinedTextField(
                value = value,
                onValueChange = { },
                readOnly = true,
                trailingIcon = {
                    Icon(Icons.Default.ArrowDropDown, "$label dropdown",
                        Modifier.clickable { onExpandChange(!isExpanded) })
                },
                modifier = Modifier.fillMaxWidth()
            )
            
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { onExpandChange(false) },
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {
                options.forEach { option ->
                    DropdownMenuItem(onClick = {
                        onOptionSelected(option)
                        onExpandChange(false)
                    }) {
                        Text(text = option)
                    }
                }
            }
        }
    }
}

@Composable
fun RunnerRegistrationScreen(navigator: Navigator) {
    // State variables for form fields
    var formState by remember { mutableStateOf(RunnerFormState()) }
    
    // States for dropdowns and dialog visibility
    var genderExpanded by remember { mutableStateOf(false) }
    var countryExpanded by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    
    // Validation error states
    var errors by remember { mutableStateOf(ValidationErrors()) }
    
    // Options for dropdowns
    val genderOptions = listOf("Мужской", "Женский")
    val countryOptions = listOf("Russia", "USA", "UK", "Germany", "France", "Italy", "Spain", "China", "Japan", "Australia")
    
    val scrollState = rememberScrollState()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Регистрация бегуна",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        
        Text(
            text = "Пожалуйста заполните всю информацию, чтобы зарегистрироваться в качестве бегуна",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Регистрация бегуна",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        
        Text(
            text = "Пожалуйста заполните всю информацию, чтобы зарегистрироваться в качестве бегуна",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f).padding(end = 8.dp)) {
                // Email field
                FormTextField(
                    value = formState.email,
                    onValueChange = { newEmail -> 
                        formState = formState.copy(email = newEmail)
                        errors = errors.copy(email = false)
                    },
                    label = "Email:",
                    isError = errors.email
                )
                
                // Password field
                FormTextField(
                    value = formState.password,
                    onValueChange = { newPassword -> 
                        formState = formState.copy(password = newPassword)
                        errors = errors.copy(
                            password = false,
                            passwordMatch = formState.confirmPassword.isNotEmpty() && 
                                          newPassword != formState.confirmPassword
                        )
                    },
                    label = "Пароль:",
                    isError = errors.password || errors.passwordMatch,
                    isPassword = true
                )
                
                // Confirm password field
                FormTextField(
                    value = formState.confirmPassword,
                    onValueChange = { newConfirmPassword -> 
                        formState = formState.copy(confirmPassword = newConfirmPassword)
                        errors = errors.copy(
                            confirmPassword = false,
                            passwordMatch = newConfirmPassword.isNotEmpty() && 
                                          formState.password != newConfirmPassword
                        )
                    },
                    label = "Повторите пароль:",
                    isError = errors.confirmPassword || errors.passwordMatch,
                    errorText = if (errors.passwordMatch) "Пароли не совпадают" else "Это поле обязательно для заполнения",
                    isPassword = true
                )
                
                // First name field
                FormTextField(
                    value = formState.firstName,
                    onValueChange = { newFirstName -> 
                        formState = formState.copy(firstName = newFirstName)
                        errors = errors.copy(firstName = false)
                    },
                    label = "Имя:",
                    isError = errors.firstName
                )
                
                // Last name field
                FormTextField(
                    value = formState.lastName,
                    onValueChange = { newLastName -> 
                        formState = formState.copy(lastName = newLastName)
                        errors = errors.copy(lastName = false)
                    },
                    label = "Фамилия:",
                    isError = errors.lastName
                )
                
                // Gender dropdown
                FormDropdown(
                    value = formState.gender,
                    options = genderOptions,
                    isExpanded = genderExpanded,
                    onExpandChange = { isExpanded -> genderExpanded = isExpanded },
                    onOptionSelected = { selectedGender -> formState = formState.copy(gender = selectedGender) },
                    label = "Пол:"
                )
                }
            }
            
            Column(
                modifier = Modifier.weight(1f).padding(start = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Photo preview box
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(color = Color.LightGray)
                        .border(1.dp, Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Фото")
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Photo file selection
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = formState.photoPath,
                        onValueChange = { newPath -> formState = formState.copy(photoPath = newPath) },
                        modifier = Modifier.weight(1f).padding(end = 4.dp)
                    )
                    
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
                    ) {
                        Text("Просмотр...")
                    }
                }
                
                // Date of birth field with date picker dialog
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Дата рождения:",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    
                    OutlinedTextField(
                        value = formState.birthDate,
                        onValueChange = { },
                        readOnly = true,
                        trailingIcon = {
                            Icon(Icons.Default.KeyboardArrowDown, "Выбрать дату",
                                Modifier.clickable { showDatePicker = true })
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
                
                // Simplified date picker dialog
                if (showDatePicker) {
                    Dialog(onDismissRequest = { showDatePicker = false }) {
                        Card(
                            modifier = Modifier.padding(16.dp),
                            backgroundColor = Color.White,
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    "Выберите дату рождения",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(bottom = 16.dp)
                                )
                                
                                // Sample dates
                                val dates = listOf("1978-07-16", "1980-01-01", "1985-05-15", "1990-12-31")
                                
                                Column {
                                    dates.forEach { date ->
                                        TextButton(
                                            onClick = {
                                                formState = formState.copy(birthDate = date)
                                                showDatePicker = false
                                            }
                                        ) {
                                            Text(date)
                                        }
                                    }
                                }
                                
                                Button(
                                    onClick = { showDatePicker = false },
                                    modifier = Modifier.align(Alignment.End).padding(top = 8.dp)
                                ) {
                                    Text("Отмена")
                                }
                            }
                        }
                    }
                }
                
                // Country dropdown
                FormDropdown(
                    value = formState.country,
                    options = countryOptions,
                    isExpanded = countryExpanded,
                    onExpandChange = { isExpanded -> countryExpanded = isExpanded },
                    onOptionSelected = { selectedCountry -> formState = formState.copy(country = selectedCountry) },
                    label = "Страна:"
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    // Validate all required fields
                    val newErrors = ValidationErrors(
                        email = formState.email.isEmpty(),
                        password = formState.password.isEmpty(),
                        confirmPassword = formState.confirmPassword.isEmpty(),
                        passwordMatch = formState.password != formState.confirmPassword && 
                                        formState.password.isNotEmpty() && 
                                        formState.confirmPassword.isNotEmpty(),
                        firstName = formState.firstName.isEmpty(),
                        lastName = formState.lastName.isEmpty()
                    )
                    
                    errors = newErrors
                    
                    // Navigate to confirmation screen if valid
                    if (!newErrors.email && !newErrors.password && !newErrors.confirmPassword && 
                        !newErrors.passwordMatch && !newErrors.firstName && !newErrors.lastName) {
                        navigator.navigateTo(Screen.REGISTRATION_CONFIRMATION)
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text("Регистрация", color = Color.White)
            }
            
            OutlinedButton(
                onClick = { navigator.goBack() },
                contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
            ) {
                Text("Отмена")
            }
        }
    }
}

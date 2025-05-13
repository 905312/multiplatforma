package org.example.marafon

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Marathon Skills 2016",
        state = WindowState(size = DpSize(800.dp, 600.dp))
    ) {
        App()
    }
}
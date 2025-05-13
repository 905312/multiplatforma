package org.example.marafon

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
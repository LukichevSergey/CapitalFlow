package com.example.capitalflow

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
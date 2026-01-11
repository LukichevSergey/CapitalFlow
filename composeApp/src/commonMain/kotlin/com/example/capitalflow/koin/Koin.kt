package com.example.capitalflow.koin

import com.example.capitalflow.di.initKoin

// Обертка для iOS - экспортируется как KoinKt.doInitKoin()
fun doInitKoin() {
    initKoin()
}
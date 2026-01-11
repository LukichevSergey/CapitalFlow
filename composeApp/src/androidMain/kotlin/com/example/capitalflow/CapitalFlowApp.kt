package com.example.capitalflow

import android.app.Application
import com.example.capitalflow.di.initKoin

class CapitalFlowApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
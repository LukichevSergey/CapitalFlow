package com.example.capitalflow.di

import com.example.capitalflow.repository.GameRepository
import com.example.capitalflow.screen.earning.EarningViewModel
import com.example.capitalflow.screen.home.HomeViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val gameModule = module {
    single { GameRepository() }
}

val viewModelModule = module {
    factoryOf(::HomeViewModel)
    factoryOf(::EarningViewModel)
}

fun initKoin() {
    startKoin {
        modules(
            gameModule,
            viewModelModule,
        )
    }
}
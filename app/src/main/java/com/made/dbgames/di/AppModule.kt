package com.made.dbgames.di

import com.made.dbgames.core.domain.usecase.GameInteractor
import com.made.dbgames.core.domain.usecase.GameUseCase
import com.made.dbgames.detail.DetailViewModel
import com.made.dbgames.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GameUseCase> { GameInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}
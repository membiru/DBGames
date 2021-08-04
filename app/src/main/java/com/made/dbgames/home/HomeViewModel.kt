package com.made.dbgames.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.made.dbgames.core.domain.usecase.GameUseCase

class HomeViewModel(gameUseCase: GameUseCase) : ViewModel() {

    val gameList = gameUseCase.getAllGame().asLiveData()

}


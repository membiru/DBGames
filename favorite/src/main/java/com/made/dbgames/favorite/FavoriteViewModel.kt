package com.made.dbgames.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.made.dbgames.core.domain.usecase.GameUseCase

class FavoriteViewModel(gameUseCase: GameUseCase) : ViewModel() {

    val favoriteGame = gameUseCase.getFavoriteGame().asLiveData()

}
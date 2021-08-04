package com.made.dbgames.detail

import androidx.lifecycle.ViewModel
import com.made.dbgames.core.domain.model.Game
import com.made.dbgames.core.domain.usecase.GameUseCase

class DetailViewModel(private val gameUseCase: GameUseCase) : ViewModel() {
    fun setFavoriteGame(game: Game, newStatus:Boolean) = gameUseCase.setFavoriteGame(game, newStatus)
}


package com.made.dbgames.core.domain.usecase

import com.made.dbgames.core.domain.model.Game
import com.made.dbgames.core.domain.repository.IGameRepository

class GameInteractor(private val gameRepository: IGameRepository): GameUseCase {

    override fun getAllGame() = gameRepository.getAllGame()

    override fun getFavoriteGame() = gameRepository.getFavoriteGame()

    override fun setFavoriteGame(game: Game, state: Boolean) = gameRepository.setFavoriteGame(game, state)
}
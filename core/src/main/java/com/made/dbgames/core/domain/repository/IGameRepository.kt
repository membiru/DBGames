package com.made.dbgames.core.domain.repository

import com.made.dbgames.core.data.Resource
import com.made.dbgames.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface IGameRepository {
    fun getAllGame(): Flow<Resource<List<Game>>>

    fun getFavoriteGame(): Flow<List<Game>>

    fun setFavoriteGame(game: Game, state: Boolean)
}
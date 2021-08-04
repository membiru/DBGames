package com.made.dbgames.core.utils

import com.made.dbgames.core.data.source.local.entity.GameEntity
import com.made.dbgames.core.data.source.remote.response.GameResponse
import com.made.dbgames.core.domain.model.Game

object DataMapper {
    fun mapResponsesToEntities(input: List<GameResponse>): List<GameEntity> {
        val gamesList = ArrayList<GameEntity>()
        input.map {
            val game = GameEntity(
                gameId = it.id,
                name = it.name,
                released = it.released,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                ratingsCount = it.ratingsCount,
                isFavorite = false
            )
            gamesList.add(game)
        }
        return gamesList
    }

    fun mapEntitiesToDomain(input: List<GameEntity>): List<Game> =
        input.map {
            Game(
                gameId = it.gameId,
                name = it.name,
                released = it.released,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                ratingsCount = it.ratingsCount,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Game) = GameEntity(
        gameId = input.gameId,
        name = input.name,
        released = input.released,
        backgroundImage = input.backgroundImage,
        rating = input.rating,
        ratingsCount = input.ratingsCount,
        isFavorite = input.isFavorite
    )
}
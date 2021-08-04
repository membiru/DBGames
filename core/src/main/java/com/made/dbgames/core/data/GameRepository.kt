package com.made.dbgames.core.data

import kotlinx.coroutines.flow.*
import com.made.dbgames.core.data.source.remote.network.ApiResponse
import com.made.dbgames.core.data.source.local.LocalDataSource
import com.made.dbgames.core.data.source.remote.RemoteDataSource
import com.made.dbgames.core.data.source.remote.response.GameResponse
import com.made.dbgames.core.domain.model.Game
import com.made.dbgames.core.domain.repository.IGameRepository
import com.made.dbgames.core.utils.AppExecutors
import com.made.dbgames.core.utils.DataMapper

class GameRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IGameRepository {

    override fun getAllGame(): Flow<Resource<List<Game>>> =
        object : NetworkBoundResource<List<Game>, List<GameResponse>>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getAllGame().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Game>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponse>>> =
                remoteDataSource.getAllGame()

            override suspend fun saveCallResult(data: List<GameResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertGame(tourismList)
            }
        }.asFlow()

    override fun getFavoriteGame(): Flow<List<Game>> {
        return localDataSource.getFavoriteGame().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteGame(game: Game, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(game)
        appExecutors.diskIO().execute { localDataSource.setFavoriteGame(tourismEntity, state) }
    }
}


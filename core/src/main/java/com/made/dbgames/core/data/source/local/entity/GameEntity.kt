package com.made.dbgames.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "gameId")
    var gameId: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "released")
    var released: String,

    @ColumnInfo(name = "background_image")
    var backgroundImage: String,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "ratings_count")
    var ratingsCount: Int,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false

) : Parcelable

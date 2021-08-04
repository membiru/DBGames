package com.made.dbgames.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(
    val gameId: String,
    var name: String,
    var released: String,
    var backgroundImage: String,
    var rating: Double,
    var ratingsCount: Int,
    var isFavorite: Boolean

) : Parcelable
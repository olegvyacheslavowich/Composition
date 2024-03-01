package ru.elipson.composition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class Level : Parcelable {
    data object Test : Level()
    data object Easy : Level()
    data object Normal : Level()
    data object Hard : Level()

}
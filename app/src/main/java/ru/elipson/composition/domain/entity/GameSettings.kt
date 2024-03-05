package ru.elipson.composition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameSettings(
    val maxSumValue: Int = 1,
    val minCountOfWriteAnswers: Int = 1,
    val minPercentOfWriteAnswers: Int = 20,
    val gameTimeInSec: Int = 60
) : Parcelable
package ru.elipson.composition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameSettings(
    private val maxSumValue: Int = 1,
    private val minCountOfWriteAnswers: Int = 1,
    private val minPercentOfWriteAnswers: Int = 20,
    private val gameTimeInSec: Int = 60
) : Parcelable
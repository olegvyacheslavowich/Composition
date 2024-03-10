package ru.elipson.composition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameResult(
    private val winner: Boolean = true,
    val countOfWriteAnswers: Int = 0,
    val countOfQuestions: Int = 0,
    val gameSetting: GameSettings
) : Parcelable
package ru.elipson.composition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameResult(
    private val winner: Boolean = true,
    private val countOfWriteAnswers: Int = 0,
    private val countOfQuestions: Int = 0,
    private val gameSetting: GameSettings
) : Parcelable
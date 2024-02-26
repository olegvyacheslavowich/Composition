package ru.elipson.composition.domain.entity

data class GameResult(
    private val winner: Boolean,
    private val countOfWriteAnswers: Int,
    private val countOfQuestions: Int,
    private val gameSetting: GameSettings
)
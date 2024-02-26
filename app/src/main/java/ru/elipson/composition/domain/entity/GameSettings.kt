package ru.elipson.composition.domain.entity

data class GameSettings(
    private val maxSumValue: Int,
    private val minCountOfWriteAnswers: Int,
    private val minPercentOfWriteAnswers: Int,
    private val gameTimeInSec: Int
)
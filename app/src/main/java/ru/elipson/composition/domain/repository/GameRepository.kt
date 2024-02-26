package ru.elipson.composition.domain.repository

import ru.elipson.composition.domain.entity.GameSettings
import ru.elipson.composition.domain.entity.Level
import ru.elipson.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings

}
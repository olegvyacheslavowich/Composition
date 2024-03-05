package ru.elipson.composition.data

import ru.elipson.composition.domain.entity.GameSettings
import ru.elipson.composition.domain.entity.Level
import ru.elipson.composition.domain.entity.Question
import ru.elipson.composition.domain.repository.GameRepository
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {
    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(2, maxSumValue + 1)
        val visibleNumber = Random.nextInt(20 )
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val to = 10
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(to))
        }
        return Question(sum, visibleNumber, options.toList())
    }
    override fun getGameSettings(level: Level): GameSettings =
        when (level) {
            is Level.Test -> GameSettings(5, 5, 50, 100)
            Level.Easy -> GameSettings(5, 5, 50, 100)
            Level.Hard -> GameSettings(5, 5, 50, 100)
            Level.Normal -> GameSettings(5, 5, 50, 100)
        }

}
package ru.elipson.composition.domain.usecases

import ru.elipson.composition.domain.entity.Question
import ru.elipson.composition.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(maxSumValue: Int): Question =
        repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)

    private companion object {
        private const val COUNT_OF_OPTIONS = 6
    }

}
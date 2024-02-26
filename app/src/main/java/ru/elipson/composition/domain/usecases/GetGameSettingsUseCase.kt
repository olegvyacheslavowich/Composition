package ru.elipson.composition.domain.usecases

import ru.elipson.composition.domain.entity.GameSettings
import ru.elipson.composition.domain.entity.Level
import ru.elipson.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings = repository.getGameSettings(level)

}
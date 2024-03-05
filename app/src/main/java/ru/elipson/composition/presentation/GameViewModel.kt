package ru.elipson.composition.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.elipson.composition.data.GameRepositoryImpl
import ru.elipson.composition.domain.entity.GameSettings
import ru.elipson.composition.domain.entity.Level
import ru.elipson.composition.domain.usecases.GenerateQuestionUseCase
import ru.elipson.composition.domain.usecases.GetGameSettingsUseCase

class GameViewModel : ViewModel() {


    private val repository = GameRepositoryImpl
    private val generateQuestionUseCase = GenerateQuestionUseCase(repository)
    private val getGameSettingsUseCase = GetGameSettingsUseCase(repository)

    private val _gameSettingsLiveData = MutableLiveData<GameSettings>()
    val gameSettingsLiveData: LiveData<GameSettings> get() = _gameSettingsLiveData

    private val _timeLiveData = MutableLiveData<GameSettings>()
    val timeLiveData: LiveData<GameSettings> get() = _timeLiveData

    init {
        _gameSettingsLiveData.value = getGameSettingsUseCase(Level.Normal)
    }






}
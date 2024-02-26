package ru.elipson.composition.domain.entity

sealed class Level {
    data object Test : Level()
    data object Easy : Level()
    data object Normal : Level()
    data object Hard : Level()
}
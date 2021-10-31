package me.padamchopra.biblioteca.mapper

internal interface DataMapper<I, O> {
    fun mapTo(input: I): O
}
package com.stroke.stroke_ch2_ps208.data.network


sealed class ResultState<out R> private constructor() {
    data class Success<T>(val data: T) : ResultState<T>()
    data class Error(val error: String) : ResultState<Nothing>()
    object Loading : ResultState<Nothing>()
}
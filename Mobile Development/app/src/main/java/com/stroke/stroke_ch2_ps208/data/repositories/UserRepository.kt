package com.stroke.stroke_ch2_ps208.data.repositories

import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.stroke.stroke_ch2_ps208.data.local.SharedPreferences
import com.stroke.stroke_ch2_ps208.data.network.ResultState
import com.stroke.stroke_ch2_ps208.data.network.api.ApiConfig
import com.stroke.stroke_ch2_ps208.model.SignIn
import com.stroke.stroke_ch2_ps208.model.SignUp

class UserRepository private constructor(
    private val sharedPreferences: SharedPreferences,
    private val apiService: ApiConfig,
) {
    suspend fun saveToken(token: String) {
        sharedPreferences.saveToken(token)
    }

    fun getToken() = sharedPreferences.getToken().asLiveData()

    suspend fun deleteToken() = sharedPreferences.deleteToken()

    fun signIn(signIn: SignIn) = liveData {
        emit(ResultState.Loading)
        try {
            val response = apiService.apiService().signIn(signIn)
            emit(ResultState.Success(response))
        } catch (exc: Exception) {
            emit(ResultState.Error(exc.message.toString()))
        }
    }

    fun signUp(signUp: SignUp) = liveData {
        emit(ResultState.Loading)
        try {
            val response = apiService.apiService().signUp(signUp)
            emit(ResultState.Success(response))
        } catch (exc: Exception) {
            emit(ResultState.Error(exc.message.toString()))
        }
    }

    companion object {
        private var instance: UserRepository? = null
        fun getInstance(
            sharedPreferences: SharedPreferences,
            apiService: ApiConfig
        ) = instance ?: synchronized(this) {
            instance ?: UserRepository(sharedPreferences, apiService)
        }.also { instance = it }
    }
}
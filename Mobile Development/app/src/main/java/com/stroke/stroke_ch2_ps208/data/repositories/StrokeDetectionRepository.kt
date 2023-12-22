package com.stroke.stroke_ch2_ps208.data.repositories

import androidx.lifecycle.liveData
import com.stroke.stroke_ch2_ps208.data.network.ResultState
import com.stroke.stroke_ch2_ps208.data.network.api.ApiConfig
import com.stroke.stroke_ch2_ps208.model.StrokeDetectionRequest

class StrokeAssessmentRepository (private val apiService: ApiConfig){

    fun strokeDetection(token: String, request: StrokeDetectionRequest) = liveData {
        println("Starting strokeDetection function")

        emit(ResultState.Loading)
        try {
            val response = apiService.apiService(token).strokeDetection(request)
            println("StrokeDetection API call successful")
            emit(ResultState.Success(response))
        } catch (exc: Exception) {
            println("StrokeDetection API call failed with exception: ${exc.message}")
            emit(ResultState.Error(exc.message.toString()))
        }
        println("Ending strokeDetection function")
    }

    companion object {
        private var instance: StrokeAssessmentRepository? = null
        fun getInstance(apiService: ApiConfig) = instance ?: synchronized(this) {
            instance ?: StrokeAssessmentRepository(apiService)
        }.also { instance = it }
    }
}
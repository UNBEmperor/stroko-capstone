package com.stroke.stroke_ch2_ps208.di

import android.content.Context
import com.stroke.stroke_ch2_ps208.data.local.SharedPreferences
import com.stroke.stroke_ch2_ps208.data.network.api.ApiConfig
import com.stroke.stroke_ch2_ps208.data.repositories.StrokeAssessmentRepository
import com.stroke.stroke_ch2_ps208.data.repositories.UserRepository

object Injection {
    fun provideUserRepository(context: Context): UserRepository {
        val sharedPreferences = SharedPreferences.getInstance(context)
        val apiConfig = ApiConfig
        return UserRepository.getInstance(sharedPreferences,apiConfig )
    }

    fun provideStrokeDetectionRepository(): StrokeAssessmentRepository {
        val apiConfig = ApiConfig
        return StrokeAssessmentRepository.getInstance(apiConfig)
    }
}
package com.stroke.stroke_ch2_ps208.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stroke.stroke_ch2_ps208.data.repositories.StrokeAssessmentRepository
import com.stroke.stroke_ch2_ps208.data.repositories.UserRepository
import com.stroke.stroke_ch2_ps208.di.Injection
import com.stroke.stroke_ch2_ps208.ui.home.HomeViewModel
import com.stroke.stroke_ch2_ps208.ui.profile.ProfileViewModel
import com.stroke.stroke_ch2_ps208.ui.signin.SignInViewModel
import com.stroke.stroke_ch2_ps208.ui.signup.SignUpViewModel
import com.stroke.stroke_ch2_ps208.ui.splashscreen.SplashViewModel
import com.stroke.stroke_ch2_ps208.ui.strokedetection.StrokeDetectionViewModel

class ViewModelFactory private constructor(
    private val userRepository: UserRepository,
    private val strokeDetectionRepository: StrokeAssessmentRepository,
) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SignInViewModel::class.java) -> SignInViewModel(
                userRepository
            ) as T

            modelClass.isAssignableFrom(SignUpViewModel::class.java) -> SignUpViewModel(
                userRepository
            ) as T

            modelClass.isAssignableFrom(SplashViewModel::class.java) -> SplashViewModel(
                userRepository
            ) as T

            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> ProfileViewModel(
                userRepository
            ) as T

            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(
                userRepository, strokeDetectionRepository
            ) as T

            modelClass.isAssignableFrom(StrokeDetectionViewModel::class.java) -> StrokeDetectionViewModel(
                userRepository, strokeDetectionRepository
            ) as T

            else -> throw IllegalArgumentException("Invalid ViewModel class: ${modelClass.name}")
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: ViewModelFactory(
                    userRepository = Injection.provideUserRepository(context),
                    strokeDetectionRepository = Injection.provideStrokeDetectionRepository()
                )
            }.also {
                INSTANCE = it
            }
    }
}
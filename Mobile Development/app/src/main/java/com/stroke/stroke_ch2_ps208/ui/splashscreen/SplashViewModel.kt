package com.stroke.stroke_ch2_ps208.ui.splashscreen

import androidx.lifecycle.ViewModel
import com.stroke.stroke_ch2_ps208.data.repositories.UserRepository

class SplashViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun getToken() = userRepository.getToken()
}
package com.stroke.stroke_ch2_ps208.ui.signup

import androidx.lifecycle.ViewModel
import com.stroke.stroke_ch2_ps208.data.repositories.UserRepository
import com.stroke.stroke_ch2_ps208.model.SignUp

class SignUpViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun signUp(signUp: SignUp) = userRepository.signUp(signUp)
}
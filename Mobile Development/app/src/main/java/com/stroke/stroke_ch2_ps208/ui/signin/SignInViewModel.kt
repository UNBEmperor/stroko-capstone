package com.stroke.stroke_ch2_ps208.ui.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stroke.stroke_ch2_ps208.data.repositories.UserRepository
import com.stroke.stroke_ch2_ps208.model.SignIn
import kotlinx.coroutines.launch

class SignInViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun signIn(signIn: SignIn) = userRepository.signIn(signIn)
    fun saveToken(token: String) {
        viewModelScope.launch {
            userRepository.saveToken(token)
        }
    }
}
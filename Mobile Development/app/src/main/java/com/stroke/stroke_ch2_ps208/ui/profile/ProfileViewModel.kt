package com.stroke.stroke_ch2_ps208.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stroke.stroke_ch2_ps208.data.repositories.UserRepository
import kotlinx.coroutines.launch

class ProfileViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun logout() {
        viewModelScope.launch {
            userRepository.deleteToken()
        }
    }
}
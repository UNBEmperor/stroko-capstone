package com.stroke.stroke_ch2_ps208.ui.home

import androidx.lifecycle.ViewModel
import com.stroke.stroke_ch2_ps208.data.repositories.StrokeAssessmentRepository
import com.stroke.stroke_ch2_ps208.data.repositories.UserRepository

class HomeViewModel(
    private val userRepository: UserRepository,
    private val articleRepository: StrokeAssessmentRepository,
) : ViewModel() {

    fun getToken() = userRepository.getToken()
}
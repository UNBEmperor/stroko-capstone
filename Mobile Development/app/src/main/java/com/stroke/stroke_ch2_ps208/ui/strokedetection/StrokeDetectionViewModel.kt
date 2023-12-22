package com.stroke.stroke_ch2_ps208.ui.strokedetection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stroke.stroke_ch2_ps208.data.network.ResultState
import com.stroke.stroke_ch2_ps208.data.network.response.StrokeAssessmentResponse
import com.stroke.stroke_ch2_ps208.data.repositories.StrokeAssessmentRepository
import com.stroke.stroke_ch2_ps208.data.repositories.UserRepository
import com.stroke.stroke_ch2_ps208.model.StrokeDetectionRequest
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class StrokeDetectionViewModel(
    private val userRepository: UserRepository,
    private val strokeAssessmentRepository: StrokeAssessmentRepository,
) : ViewModel() {

    fun getToken() = userRepository.getToken()

    fun strokeDetection(token: String, request: StrokeDetectionRequest) =
        strokeAssessmentRepository.strokeDetection(token, request)
}
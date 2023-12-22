package com.stroke.stroke_ch2_ps208.data.network.api

import com.stroke.stroke_ch2_ps208.data.network.response.StrokeAssessmentResponse
import com.stroke.stroke_ch2_ps208.model.FoodRecomendationResponse
import com.stroke.stroke_ch2_ps208.model.SignIn
import com.stroke.stroke_ch2_ps208.model.SignInResponse
import com.stroke.stroke_ch2_ps208.model.SignUp
import com.stroke.stroke_ch2_ps208.model.SignUpResponse
import com.stroke.stroke_ch2_ps208.model.StrokeDetectionRequest
import com.stroke.stroke_ch2_ps208.utils.EndPoint
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST

interface ApiService {

    @POST(EndPoint.SignIn)
    suspend fun signIn(@Body signIn: SignIn): SignInResponse

    @POST(EndPoint.SignUp)
    suspend fun signUp(@Body signup: SignUp): SignUpResponse

    @POST(EndPoint.StrokeDetection)
    suspend fun strokeDetection(@Body request: StrokeDetectionRequest): StrokeAssessmentResponse

    @POST(EndPoint.FoodRecomendation)
    suspend fun fooodRecomendation(@Body request: StrokeDetectionRequest) : FoodRecomendationResponse
}
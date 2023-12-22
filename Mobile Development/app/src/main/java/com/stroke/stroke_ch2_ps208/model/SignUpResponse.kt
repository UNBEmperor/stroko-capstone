package com.stroke.stroke_ch2_ps208.model

data class SignUpResponse(
    val error: Boolean,
    val message: String? = null,
    val data: SignUpData
)

data class SignUpData(
    val _id: String,
    val name: String,
    val email: String,
    val password: String,
    val createdAt: String
)

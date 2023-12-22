package com.stroke.stroke_ch2_ps208.model

import com.google.gson.annotations.SerializedName

data class FoodRecomendationResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)


data class Data(

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("keterangan")
	val keterangan: String,

	@field:SerializedName("kandungan1")
	val kandungan1: Any,

	@field:SerializedName("kandunganN")
	val kandunganN: Any,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("fotoMakanan")
	val fotoMakanan: String,

	@field:SerializedName("idStrokeAssessment")
	val idStrokeAssessment: Int,

	@field:SerializedName("namaMakanan")
	val namaMakanan: String,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)

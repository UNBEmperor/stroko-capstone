package com.stroke.stroke_ch2_ps208.data.network.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class StrokeAssessmentResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
) : Parcelable

@Parcelize
data class Data(

	@field:SerializedName("usia")
	val usia: Int,

	@field:SerializedName("gender")
	val gender: Boolean,

	@field:SerializedName("prediksiStroke")
	val prediksiStroke: Boolean,

	@field:SerializedName("riwayatStrokePribadi")
	val riwayatStrokePribadi: Boolean,

	@field:SerializedName("merokok")
	val merokok: String,

	@field:SerializedName("konsumsiAlkohol")
	val konsumsiAlkohol: String,

	@field:SerializedName("levelBMI")
	val levelBMI: Float,

	@field:SerializedName("hipertensi")
	val hipertensi: Boolean,

	@field:SerializedName("aktivitasFisik")
	val aktivitasFisik: String,

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("penyakitJantung")
	val penyakitJantung: Boolean,

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("riwayatStrokeKeluarga")
	val riwayatStrokeKeluarga: Boolean,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("idUsers")
	val idUsers: Int,

	@field:SerializedName("diabetes")
	val diabetes: Boolean,

	@field:SerializedName("updatedAt")
	val updatedAt: String
) : Parcelable

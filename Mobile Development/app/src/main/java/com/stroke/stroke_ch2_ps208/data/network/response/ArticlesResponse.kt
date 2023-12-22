package com.stroke.stroke_ch2_ps208.data.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ArticlesResponse(

	@field:SerializedName("data")
	val data: List<ArticleData>,

	@field:SerializedName("status")
	val status: Int,
)

@Parcelize
data class ArticleData(
	@field:SerializedName("fotoArtikel")
	val fotoArtikel: String,

	@field:SerializedName("penerbit")
	val penerbit: String,

	@field:SerializedName("judulArtikel")
	val judulArtikel: String,

	@field:SerializedName("tanggal")
	val tanggal: String,
): Parcelable

package com.stroke.stroke_ch2_ps208.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StrokeDetectionRequest(
    val usia: Int,
    val gender: Boolean,
    val levelBMI: Float,
    val hipertensi: Boolean,
    val diabetes: Boolean,
    val penyakitJantung: Boolean,
    val riwayatStrokePribadi: Boolean,
    val riwayatStrokeKeluarga: Boolean,
    val merokok: String,
    val konsumsiAlkohol: String,
    val aktivitasFisik: String,
    val prediksiStroke: Boolean = false
): Parcelable
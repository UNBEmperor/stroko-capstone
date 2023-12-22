package com.stroke.stroke_ch2_ps208.ui.detail.detaildetection

import android.os.Bundle
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.stroke.stroke_ch2_ps208.R
import com.stroke.stroke_ch2_ps208.data.network.response.StrokeAssessmentResponse
import com.stroke.stroke_ch2_ps208.databinding.ActivityDetailDetectionBinding
import com.stroke.stroke_ch2_ps208.model.StrokeDetectionRequest
import com.stroke.stroke_ch2_ps208.ui.home.HomeFragment

class DetailDetectionActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityDetailDetectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDetailDetectionBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        renderStrokeDetectionDetail()
        viewBinding.btnHome.setOnClickListener {
            // Panggil fungsi untuk membuka HomeFragment di sini
            openHomeFragment()
        }

    }

    private fun renderStrokeDetectionDetail() {
        val strokeAssessmentResponse = intent.getParcelableExtra<StrokeDetectionRequest>(PREDICTION)
        viewBinding.apply {
            if (strokeAssessmentResponse != null) {
                showHighDetectionLayout()
            } else {
                showLowDetectionLayout()
            }
        }
    }

    private fun showHighDetectionLayout() {
        viewBinding.imgDetection.setImageResource(R.drawable.ic_detail)
        viewBinding.tvDiagnosa.text = getString(R.string.output_detection_hight)
        viewBinding.description.text = getString(R.string.outputDescriptionHight)
        viewBinding.imgContainer2.setImageResource(R.drawable.dr_page_container_up)
    }

    private fun showLowDetectionLayout() {
        viewBinding.imgDetection.setImageResource(R.drawable.ic_low_detection)
        viewBinding.tvDiagnosa.text = getString(R.string.output_detection_low)
        viewBinding.description.text = getString(R.string.outputDescriptionLow)
        viewBinding.imgContainer2.setImageResource(R.drawable.bg_low_detection)
    }

    private fun openHomeFragment() {
        val intent = Intent(this, HomeFragment::class.java)
        startActivity(intent)
        finish()
    }

    companion object {
        const val PREDICTION = "PREDICTION"
    }
}

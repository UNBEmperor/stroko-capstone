package com.stroke.stroke_ch2_ps208.ui.onboarding

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.stroke.stroke_ch2_ps208.R
import com.stroke.stroke_ch2_ps208.databinding.ActivityOnboardingBinding
import com.stroke.stroke_ch2_ps208.ui.signin.SignInActivity

class OnboardingActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var onboardingBinding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onboardingBinding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(onboardingBinding.root)

        setupView()

        onboardingBinding.btnGetStarted.setOnClickListener(this)
        onboardingBinding.btnSkip.setOnClickListener(this)
        onboardingBinding.btnNext.setOnClickListener{
            val currentState = onboardingBinding.onboard.currentState
            when (currentState) {
                R.id.start -> onboardingBinding.onboard.transitionToState(R.id.menu2)
                R.id.menu2 -> onboardingBinding.onboard.transitionToState(R.id.menu3)
                R.id.menu3 -> {
                    navigateToMainActivity()
                }
            }
        }

    }


    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnGetStarted -> {
                navigateToMainActivity()
            }

            R.id.btnSkip -> {
                navigateToMainActivity()
            }

        }
    }

    private fun navigateToMainActivity() {
        val moveIntent = Intent(this@OnboardingActivity, SignInActivity::class.java)
        finish()
        startActivity(moveIntent)
    }
}
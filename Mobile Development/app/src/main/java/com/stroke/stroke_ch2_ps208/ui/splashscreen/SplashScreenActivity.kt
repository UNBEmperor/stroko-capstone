package com.stroke.stroke_ch2_ps208.ui.splashscreen

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.stroke.stroke_ch2_ps208.MainActivity
import com.stroke.stroke_ch2_ps208.databinding.ActivitySplashScreenBinding
import com.stroke.stroke_ch2_ps208.ui.ViewModelFactory
import com.stroke.stroke_ch2_ps208.ui.onboarding.OnboardingActivity
import com.stroke.stroke_ch2_ps208.ui.splashscreen.SplashViewModel
import com.stroke.stroke_ch2_ps208.ui.signin.SignInActivity
import com.stroke.stroke_ch2_ps208.ui.signup.SignUpViewModel

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var splashScreenBinding: ActivitySplashScreenBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val viewModel by viewModels<SplashViewModel> { ViewModelFactory.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(splashScreenBinding.root)

        sharedPreferences = getPreferences(MODE_PRIVATE)

        val handler = Handler(mainLooper)

        handler.postDelayed({
            checkTokenAndNavigate()
        }, 2000L)

        supportActionBar?.hide()
        customStatusBar()
    }

    private fun checkTokenAndNavigate() {
        viewModel.getToken().observe(this) { token ->
            val intent = if (token.isNotEmpty()) {
                Intent(this@SplashScreenActivity, MainActivity::class.java)
            } else {
                val isFirstTime = isFirstTime()
                if (isFirstTime) {
                    setFirstTime()
                    Intent(this@SplashScreenActivity, OnboardingActivity::class.java)
                } else {
                    Intent(this@SplashScreenActivity, SignInActivity::class.java)
                }
            }
            startActivity(intent)
            finish()
        }
    }

    @Suppress("DEPRECATION")
    private fun customStatusBar() {
        window?.decorView?.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = Color.TRANSPARENT
    }

    private fun isFirstTime(): Boolean {
        return sharedPreferences.getBoolean("is_first_time", true)
    }

    private fun setFirstTime() {
        sharedPreferences.edit().putBoolean("is_first_time", false).apply()
    }
}

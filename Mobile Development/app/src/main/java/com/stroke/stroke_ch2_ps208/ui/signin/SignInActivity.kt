package com.stroke.stroke_ch2_ps208.ui.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import com.stroke.stroke_ch2_ps208.MainActivity
import com.stroke.stroke_ch2_ps208.R
import com.stroke.stroke_ch2_ps208.data.network.ResultState
import com.stroke.stroke_ch2_ps208.databinding.ActivitySignInBinding
import com.stroke.stroke_ch2_ps208.model.SignIn
import com.stroke.stroke_ch2_ps208.ui.ViewModelFactory
import com.stroke.stroke_ch2_ps208.ui.signup.SignUpActivity

class SignInActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewBinding: ActivitySignInBinding
    private val factory = ViewModelFactory.getInstance(this)
    private val viewModel: SignInViewModel by viewModels { factory }
    private var isValidEmail = false
    private var isValidPassword = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        hideAppBar()
        addButtonListener()
        handleErrorField()
    }

    private fun hideAppBar() {
        supportActionBar?.hide()
    }


    private fun addButtonListener() {
        viewBinding.btnSignIn.setOnClickListener(this)
        viewBinding.tvSignUp.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnSignIn -> signIn()
            R.id.tvSignUp -> Intent(this, SignUpActivity::class.java).also { startActivity(it) }
        }
    }

    private fun handleErrorField() {
        viewBinding.editEmail.doOnTextChanged { text, _, _, _ ->
            if (text!!.isEmpty()) {
                viewBinding.tilEmail.isErrorEnabled = true
                viewBinding.tilEmail.error = "Email not allowed empty"
                isValidEmail = false
            } else if (!text.contains("@") || !text.contains(".")) {
                viewBinding.tilEmail.isErrorEnabled = true
                viewBinding.tilEmail.error = "Please enter valid email"
                isValidEmail = false
            } else {
                viewBinding.tilEmail.isErrorEnabled = false
                viewBinding.tilEmail.error = null
                isValidEmail = true
            }
        }

        viewBinding.editPassword.doOnTextChanged { text, _, _, _ ->
            if (text!!.isEmpty()) {
                viewBinding.tilPassword.isErrorEnabled = true
                viewBinding.tilPassword.error = "Password not allowed empty"
                isValidPassword = false
            } else {
                viewBinding.tilPassword.isErrorEnabled = false
                viewBinding.tilPassword.error = null
                isValidPassword = true
            }
        }
    }

    private fun signIn() {
        val email = viewBinding.editEmail.text.toString().trim()
        val password = viewBinding.editPassword.text.toString().trim()

        if (isValidEmail && isValidPassword) {
            val signIn = SignIn(email, password)
            viewModel.signIn(signIn).observe(this) { result ->
                when (result) {
                    is ResultState.Loading -> {
                        viewBinding.viewLoading.visibility = View.VISIBLE
                        viewBinding.tvInvalidAccount.visibility = View.GONE
                    }
                    is ResultState.Success -> {
                        viewBinding.viewLoading.visibility = View.GONE
                        viewBinding.tvInvalidAccount.visibility = View.GONE
                        val response = result.data
                        val token = response.accessToken
                        viewModel.saveToken(token)
                        Log.d(TAG, "Token received: $token")
                        Log.d(TAG, "Token length: ${token.length}")

                        if (token.length > 255) {
                            Log.e(TAG, "Token length is greater than 255 characters. This may cause issues.")
                        }
                        val intent = Intent(this@SignInActivity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                        showToast("Sign In successful")
                    }
                    is ResultState.Error -> {
                        viewBinding.viewLoading.visibility = View.GONE
                        viewBinding.tvInvalidAccount.visibility = View.VISIBLE
                        val error = result.error
                        Log.e(TAG, "Error during sign-in: $error")
                    }
                }
            }
        } else {
            showToast("Please fill in all the fields")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this@SignInActivity, message, Toast.LENGTH_SHORT).show()
    }


    companion object {
        private val TAG = SignInActivity::class.java.simpleName
    }
}
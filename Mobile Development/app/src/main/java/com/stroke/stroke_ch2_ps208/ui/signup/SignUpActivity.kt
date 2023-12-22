package com.stroke.stroke_ch2_ps208.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import com.stroke.stroke_ch2_ps208.R
import com.stroke.stroke_ch2_ps208.data.network.ResultState
import com.stroke.stroke_ch2_ps208.databinding.ActivitySignUpBinding
import com.stroke.stroke_ch2_ps208.model.SignUp
import com.stroke.stroke_ch2_ps208.ui.ViewModelFactory

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewBinding: ActivitySignUpBinding
    private val factory = ViewModelFactory.getInstance(this)
    private val viewModel: SignUpViewModel by viewModels { factory }
    private var isValidName: Boolean = false
    private var isValidEmail: Boolean = false
    private var isValidPassword: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        hideAppBar()
        addButtonListener()
        handleErrorField()
    }

    private fun hideAppBar() {
        supportActionBar?.hide()
    }


    private fun addButtonListener() {
        viewBinding.tvSignIn.setOnClickListener(this)
        viewBinding.btnSignUp.setOnClickListener(this)
    }

    private fun handleErrorField() {
        viewBinding.editName.doOnTextChanged { text, _, _, _ ->
            if (text!!.isEmpty()) {
                viewBinding.tilName.isErrorEnabled = true
                viewBinding.tilName.error = "Name not allowed empty"
                isValidName = false
            } else if (text.length < 3) {
                viewBinding.tilName.isErrorEnabled = true
                viewBinding.tilName.error = "Name min length 3 character"
                isValidName = false
            } else {
                viewBinding.tilName.isErrorEnabled = false
                viewBinding.tilName.error = null
                isValidName = true
            }
        }

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
            } else if (text.length < 6) {
                viewBinding.tilPassword.isErrorEnabled = true
                viewBinding.tilPassword.error = "Password min length 6 character"
                isValidPassword = false
            } else {
                viewBinding.tilPassword.isErrorEnabled = false
                viewBinding.tilPassword.error = null
                isValidPassword = true
            }
        }
    }


    private fun signUp() {
        val name = viewBinding.editName.text.toString().trim()
        val email = viewBinding.editEmail.text.toString().trim()
        val password = viewBinding.editPassword.text.toString().trim()

        if (isValidName && isValidEmail && isValidPassword) {
            val signUp = SignUp(name, email, password)
            viewModel.signUp(signUp).observe(this) {
                when (it) {
                    is ResultState.Loading -> {
                        viewBinding.viewLoading.visibility = View.VISIBLE
                        viewBinding.tvEmailError.visibility = View.GONE
                    }

                    is ResultState.Success -> {
                        viewBinding.viewLoading.visibility = View.GONE
                        viewBinding.tvEmailError.visibility = View.GONE
                        finish()
                        showToast("Created")
                    }

                    is ResultState.Error -> {
                        viewBinding.viewLoading.visibility = View.GONE
                        viewBinding.tvEmailError.visibility = View.VISIBLE
                    }
                }
            }
        } else {
            showToast("Please fill in all the fields")
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.tvSignIn -> finish()
            R.id.btnSignUp -> signUp()
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

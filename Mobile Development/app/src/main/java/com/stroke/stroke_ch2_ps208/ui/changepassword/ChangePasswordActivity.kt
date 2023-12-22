package com.stroke.stroke_ch2_ps208.ui.changepassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.stroke.stroke_ch2_ps208.R
import com.stroke.stroke_ch2_ps208.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewBinding: ActivityChangePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        addButtonListener()
    }

    private fun addButtonListener() {
        viewBinding.btnBack.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_back -> finish()
        }
    }
}
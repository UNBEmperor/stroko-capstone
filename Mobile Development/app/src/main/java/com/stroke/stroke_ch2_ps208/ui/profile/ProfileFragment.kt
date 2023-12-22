package com.stroke.stroke_ch2_ps208.ui.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.stroke.stroke_ch2_ps208.databinding.FragmentProfileBinding
import com.stroke.stroke_ch2_ps208.ui.ViewModelFactory
import com.stroke.stroke_ch2_ps208.ui.about.AboutActivity
import com.stroke.stroke_ch2_ps208.ui.changepassword.ChangePasswordActivity
import com.stroke.stroke_ch2_ps208.ui.signin.SignInActivity
import com.stroke.stroke_ch2_ps208.utils.DummyData
import com.stroke.stroke_ch2_ps208.utils.loadImage

class ProfileFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val fragment = this
    private val viewModel by viewModels<ProfileViewModel> { ViewModelFactory.getInstance(requireContext()) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun initView() = with(binding) {
        ivAvatar.loadImage(DummyData.provideImage()[0])
        tvAbout.setOnClickListener(fragment)
        tvEditProfile.setOnClickListener(fragment)
        tvbahasa.setOnClickListener(fragment)
        tvChangePassword.setOnClickListener(fragment)
        tvUserName.setOnClickListener(fragment)
        tvLogout.setOnClickListener(fragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    override fun onClick(v: View?) {
        with(binding) {
            when (v) {
                tvAbout -> navigateToAboutActivity()
                tvEditProfile -> {}
                tvbahasa -> openLanguageSettings()
                tvChangePassword -> navigateToChangePassword()
                tvUserName -> {}
                tvLogout -> showLogoutAlertDialog()
                else -> return
            }
        }
    }


    private fun showLogoutAlertDialog() {
        val alertBuilder = AlertDialog.Builder(requireContext())
        val alert = alertBuilder
            .setTitle("Logout")
            .setMessage("Are you sure you want to log out?")
            .setNegativeButton("No") { dialog, _ -> dialog.cancel() }
            .setPositiveButton("Yes") { _, _ ->
                logout()
            }
        alert.show()
    }

    private fun logout() {
        viewModel.logout()
        val loginIntent = Intent(requireActivity(), SignInActivity::class.java)
        startActivity(loginIntent)
        requireActivity().finishAffinity()
    }

    private fun navigateToAboutActivity() {
        val aboutIntent = Intent(requireActivity(), AboutActivity::class.java)
        startActivity(aboutIntent)
    }

    private fun openLanguageSettings() {
        startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
    }

    private fun navigateToChangePassword() {
        val changePasswordIntent = Intent(requireActivity(), ChangePasswordActivity::class.java)
        startActivity(changePasswordIntent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
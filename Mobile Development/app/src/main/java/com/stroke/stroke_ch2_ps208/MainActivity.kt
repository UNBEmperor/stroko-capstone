package com.stroke.stroke_ch2_ps208

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.stroke.stroke_ch2_ps208.databinding.ActivityMainBinding
import com.stroke.stroke_ch2_ps208.ui.favorite.FavoriteFragment
import com.stroke.stroke_ch2_ps208.ui.home.HomeFragment
import com.stroke.stroke_ch2_ps208.ui.notification.NotificationFragment
import com.stroke.stroke_ch2_ps208.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this,
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }
        loadFragment(HomeFragment())
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuHome -> loadFragment(HomeFragment())
            R.id.menuFavorite -> loadFragment(FavoriteFragment())
            R.id.menuNotifikasi -> loadFragment(NotificationFragment())
            R.id.menuProfile -> loadFragment(ProfileFragment())
            else -> false
        }
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setStatusBarColor(fragment)
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_main, fragment)
                .commit()
            return true
        }
        return false
    }

    private fun initView() = with(binding) {
        with(bnv.menu) {
            selectedItemId = R.id.menuHome
            setOnItemSelectedListener(this@MainActivity)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setStatusBarColor(fragment: Fragment?) {
        if (fragment is HomeFragment) {
            window.statusBarColor = getColor(R.color.colorAccent)
            var flags = window.decorView.systemUiVisibility
            flags = flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            window.decorView.systemUiVisibility = flags
        } else {
            window.statusBarColor = getColor(R.color.colorAccent)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    companion object {
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }
}
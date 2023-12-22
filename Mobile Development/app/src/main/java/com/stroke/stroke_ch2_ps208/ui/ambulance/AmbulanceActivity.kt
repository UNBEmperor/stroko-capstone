package com.stroke.stroke_ch2_ps208.ui.ambulance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import com.stroke.stroke_ch2_ps208.R

import com.stroke.stroke_ch2_ps208.databinding.ActivityAmbulanceBinding


class AmbulanceActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityAmbulanceBinding
//    private lateinit var fusedLocationClient:


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAmbulanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        setMapStyle()

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isIndoorLevelPickerEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true

        val myHome = LatLng(-0.971138, 119.891706)
        mMap.addMarker(
            MarkerOptions()
                .position(myHome)
                .title("Home Febriyadi")
                .snippet("Kabobona, Kec. Dolo, Kabupaten Sigi, Sulawesi Tengah 94238")
        )
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myHome, 15f))
    }

    private fun setMapStyle() {
        try {
            mMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    this,
                    R.raw.map_style
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
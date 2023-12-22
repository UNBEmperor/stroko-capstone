package com.stroke.stroke_ch2_ps208.ui.strokedetection

import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.stroke.stroke_ch2_ps208.data.network.ResultState
import com.stroke.stroke_ch2_ps208.databinding.ActivityStrokeDetectionBinding
import com.stroke.stroke_ch2_ps208.model.StrokeDetectionRequest
import com.stroke.stroke_ch2_ps208.ui.ViewModelFactory
import com.stroke.stroke_ch2_ps208.ui.detail.detaildetection.DetailDetectionActivity
import com.stroke.stroke_ch2_ps208.utils.showLoading

class StrokeDetectionActivity : AppCompatActivity() {

    private var _binding: ActivityStrokeDetectionBinding? = null
    private val binding get() = _binding!!
    private val factory = ViewModelFactory.getInstance(this)
    private val viewModel: StrokeDetectionViewModel by viewModels { factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityStrokeDetectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupSpinner()
        initView()

        binding.btnSubmit.setOnClickListener {
            performStrokeDetection()
        }
    }

    private fun setupSpinner() {
        val arrayJk = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        arrayJk.addAll(listOf("Pria", "Wanita"))
        binding.editGander.setAdapter(arrayJk)
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        arrayAdapter.addAll(listOf("Ya", "tidak"))
        binding.edHipertensi.setAdapter(arrayAdapter)
        binding.edpenyakitJantung.setAdapter(arrayAdapter)
        binding.edDiabetes.setAdapter(arrayAdapter)
        binding.edRiwayatStrokePribadi.setAdapter(arrayAdapter)
        binding.edRiwayatStrokeKeluarga.setAdapter(arrayAdapter)
        setupNumericEditText(binding.editUsia)
        setupNumericEditText(binding.edberat)
        setupNumericEditText(binding.edtinggi)
        binding.edMerokok.setAdapter(arrayAdapter)
        binding.edAlkohol.setAdapter(arrayAdapter)
        binding.edAktivitasFisik.setAdapter(arrayAdapter)
    }


    private fun initView() = with(binding) {
        editGander.setOnClickListener { editGander.showDropDown() }
        edHipertensi.setOnClickListener { edHipertensi.showDropDown() }
        edpenyakitJantung.setOnClickListener { edpenyakitJantung.showDropDown() }
        edDiabetes.setOnClickListener { edDiabetes.showDropDown() }
        edRiwayatStrokePribadi.setOnClickListener { edRiwayatStrokePribadi.showDropDown() }
        edRiwayatStrokeKeluarga.setOnClickListener { edRiwayatStrokeKeluarga.showDropDown() }
        edMerokok.setOnClickListener { edMerokok.showDropDown() }
        edAlkohol.setOnClickListener { edAlkohol.showDropDown() }
        edAktivitasFisik.setOnClickListener { edAktivitasFisik.showDropDown() }
        btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun isInputValid(): Boolean {
        val requiredFields = listOf(
            binding.edName,
            binding.editUsia,
            binding.edberat,
            binding.edtinggi,
            binding.edHipertensi,
            binding.edDiabetes,
            binding.edpenyakitJantung,
            binding.edRiwayatStrokePribadi,
            binding.edRiwayatStrokeKeluarga,
            binding.edMerokok,
            binding.edAlkohol,
            binding.edAktivitasFisik
        )
        for (field in requiredFields) {
            if (field.text.isNullOrBlank()) {
                return false
            }
        }
        return true
    }

    private fun convertToBinaryValue(input: String): String {
        return if (input == "1") {
            "1"
        } else {
            "2"
        }
    }

    private fun performStrokeDetection() {
        if (isInputValid()) {
            viewModel.getToken().observe(this) { token ->
                Log.d("StrokeDetectionActivity", "Token:$token")
                val usia = binding.editUsia.text.toString().toInt()
                val gender = binding.editGander.text.toString() == "Ya"
                val berat = binding.edberat.text.toString().toInt()
                val tinggi = binding.edtinggi.text.toString().toInt()
                val hipertensi = binding.edHipertensi.text.toString() == "Ya"
                val diabetes = binding.edDiabetes.text.toString() == "Ya"
                val penyakitJantung = binding.edpenyakitJantung.text.toString() == "Ya"
                val riwayatStrokePribadi =
                    binding.edRiwayatStrokePribadi.text.toString() == "Ya"
                val riwayatStrokeKeluarga =
                    binding.edRiwayatStrokeKeluarga.text.toString() == "Ya"
                val merokok = convertToBinaryValue(binding.edMerokok.text.toString())
                val konsumsiAlkohol = convertToBinaryValue(binding.edAlkohol.text.toString())
                val aktivitasFisik = convertToBinaryValue(binding.edAktivitasFisik.text.toString())

                val levelBMI = calculateBMI(berat, tinggi)
                val request = StrokeDetectionRequest(
                    usia,
                    gender,
                    levelBMI,
                    hipertensi,
                    diabetes,
                    penyakitJantung,
                    riwayatStrokePribadi,
                    riwayatStrokeKeluarga,
                    merokok,
                    konsumsiAlkohol,
                    aktivitasFisik,
                )
                viewModel.strokeDetection(token, request).observe(this) { result ->
                    Log.d("StrokeDetectionActivity", "Request: $request")
                    when (result) {
                        is ResultState.Loading -> {
                            Log.d("StrokeDetectionActivity", "Loading...")
                            binding.btnSubmit.showLoading(this)
                        }

                        is ResultState.Success -> {
                            Log.d("StrokeDetectionActivity", "Success: ${result.data}")
                            val intent =
                                Intent(
                                    this@StrokeDetectionActivity,
                                    DetailDetectionActivity::class.java
                                )
                            val response = result.data
                            val data = response.data.prediksiStroke
                            intent.putExtra(DetailDetectionActivity.PREDICTION, data)
                            startActivity(intent)
                            finish()
                        }

                        is ResultState.Error -> {
                            Log.d("StrokeDetectionActivity", "Error: ${result.error}")
                            val errorMessage = "Error: ${result.error}"
                            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        } else {
            Toast.makeText(this, "Semua input harus diisi", Toast.LENGTH_SHORT).show()
        }
    }


    private fun calculateBMI(berat: Int, tinggi: Int): Float {
        val tinggiInMeters = tinggi / 100.0
        val levelBMI = (berat / (tinggiInMeters * tinggiInMeters)).toFloat()
        return levelBMI
    }


    private fun setupNumericEditText(editText: EditText) {
        editText.inputType = InputType.TYPE_CLASS_NUMBER
        editText.filters = arrayOf(InputFilter.LengthFilter(3))
    }
}
package com.stroke.stroke_ch2_ps208.ui.foodrecomendation

import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.stroke.stroke_ch2_ps208.R
import com.stroke.stroke_ch2_ps208.databinding.ActivityFoodRecomendationBinding
import com.stroke.stroke_ch2_ps208.ui.detail.DetailFoodActivity
import com.stroke.stroke_ch2_ps208.ui.premium.PremiumActivity

class FoodRecomendationActivity : AppCompatActivity() {

    private var _binding: ActivityFoodRecomendationBinding? = null
    private val binding get() = _binding!!
    private var addClickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFoodRecomendationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupSpinner()
        initView()
        setupBtnAdd()
    }

    private fun setupBtnAdd() {
        val btnAdd: FloatingActionButton = findViewById(R.id.btnaddfood)
        btnAdd.setOnClickListener {
            if (addClickCount < 1) {
                val intent = Intent(this, DetailFoodActivity::class.java)
                startActivity(intent)
                addClickCount++
            } else {
                val premiumIntent = Intent(this, PremiumActivity::class.java)
                startActivity(premiumIntent)
            }
        }
    }

    private fun setupSpinner() {
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        arrayAdapter.addAll(listOf("Ya", "tidak"))
        binding.edHipertensi.setAdapter(arrayAdapter)
        binding.edpenyakitJantung.setAdapter(arrayAdapter)
        binding.edDiabetes.setAdapter(arrayAdapter)
        setupNumericEditText(binding.edWeight)
        setupNumericEditText(binding.edHeight)
    }

    private fun initView() = with(binding) {
        edHipertensi.setOnClickListener { edHipertensi.showDropDown() }
        edpenyakitJantung.setOnClickListener { edpenyakitJantung.showDropDown() }
        edDiabetes.setOnClickListener { edDiabetes.showDropDown() }
        btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun setupNumericEditText(editText: EditText) {
        editText.inputType = InputType.TYPE_CLASS_NUMBER
        editText.filters = arrayOf(InputFilter.LengthFilter(3))
    }
}
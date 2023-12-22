package com.stroke.stroke_ch2_ps208.ui.detail

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.stroke.stroke_ch2_ps208.R
import com.stroke.stroke_ch2_ps208.databinding.ActivityDetailArticlesBinding
import com.stroke.stroke_ch2_ps208.domain.enity.ListArticle
import com.stroke.stroke_ch2_ps208.utils.DummyData
import com.stroke.stroke_ch2_ps208.utils.MarginItemDecoration
import com.stroke.stroke_ch2_ps208.utils.loadImage
import com.stroke.stroke_ch2_ps208.utils.showToast

class DetailsArticleActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityDetailArticlesBinding
    private val detailslArticleAdapter = DetailAdapterArticle { view, selectedArticle ->
        if (view.id == R.id.imgBookmark) {
            val bookmarkImageView = view.findViewById<ImageView>(R.id.imgBookmark)
            selectedArticle.isFavorite = !selectedArticle.isFavorite // Toggle bookmark state

            if (selectedArticle.isFavorite) {
                bookmarkImageView.setImageResource(R.drawable.baseline_favorite_24)
                showToast("Bookmarked!")
            } else {
                bookmarkImageView.setImageResource(R.drawable.ic_favorite_border)
                showToast("Unbookmarked!")
            }
        } else {
            navigateToDetailPage(selectedArticle)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailArticlesBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        val selectedArticle = intent.getParcelableExtra<ListArticle>("selected_article")
        selectedArticle?.let { renderArticleDetail(it) }
        initView()
        initRv()
    }

    private fun renderArticleDetail(selectedArticle: ListArticle) {
        _binding.apply {
            imageView.loadImage(selectedArticle.imageUrl)
            tvTitle.text = selectedArticle.name
            tvAddress.text = selectedArticle.publish
            tvClock.text = selectedArticle.publishDate
            tvDetailDesc.text = selectedArticle.description
        }
    }

    private fun initRv() {
        detailslArticleAdapter.setData(DummyData.provideStrokeArticles())
        with(_binding.rvDetail) {
            layoutManager = LinearLayoutManager(this@DetailsArticleActivity)
            addItemDecoration(MarginItemDecoration(16))
            adapter = detailslArticleAdapter
        }
    }

    private fun navigateToDetailPage(selectedArticle: ListArticle) {
        val detailIntent = Intent(this, DetailsArticleActivity::class.java)
        detailIntent.putExtra("selected_article", selectedArticle)
        startActivity(detailIntent)
    }

    private fun initView() = with(_binding) {
        btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}

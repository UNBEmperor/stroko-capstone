package com.stroke.stroke_ch2_ps208.ui.article

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.stroke.stroke_ch2_ps208.R
import com.stroke.stroke_ch2_ps208.databinding.ActivityArticleBinding
import com.stroke.stroke_ch2_ps208.domain.enity.ListArticle
import com.stroke.stroke_ch2_ps208.ui.detail.DetailsArticleActivity
import com.stroke.stroke_ch2_ps208.utils.DummyData
import com.stroke.stroke_ch2_ps208.utils.MarginItemArticle
import com.stroke.stroke_ch2_ps208.utils.showToast

class ArticleActivity : AppCompatActivity() {
    private var _binding: ActivityArticleBinding? = null
    private val binding get() = _binding!!
    private val originalArticleList: List<ListArticle> = DummyData.provideStrokeArticles()
    private val articleAdapter = AdapterArticle { view, item ->
        if (view.id == R.id.imgBookmark) {
            val bookmarkImageView = view.findViewById<ImageView>(R.id.imgBookmark)
            item.isFavorite = !item.isFavorite
            if (item.isFavorite) {
                bookmarkImageView.setImageResource(R.drawable.baseline_favorite_24)
                showToast("Bookmarked!")
            } else {
                bookmarkImageView.setImageResource(R.drawable.ic_favorite_border)
                showToast("Unbookmarked!")
            }
        } else {
            val detailIntent = Intent(this, DetailsArticleActivity::class.java)
            detailIntent.putExtra("selected_article", item)
            startActivity(detailIntent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        binding.editSearch.addTextChangedListener { text ->
            filterArticles(text.toString())
        }
    }

    private fun filterArticles(query: String) {
        val filteredList = originalArticleList.filter { article ->
            article.name.contains(query, ignoreCase = true) || article.description.contains(
                query,
                ignoreCase = true
            )
        }
        articleAdapter.setData(filteredList)
        showEmptyView(filteredList.isEmpty())

    }
    private fun showEmptyView(show: Boolean) {
        binding.viewLoading.visibility = if (show) View.VISIBLE else View.GONE
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() = with(binding) {
        initRv()
        btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

    }

    private fun initRv() {
        articleAdapter.setData(DummyData.provideStrokeArticles())

        with(binding.rvArticleList) {
            layoutManager = LinearLayoutManager(this@ArticleActivity)
            addItemDecoration(MarginItemArticle(24))
            adapter = articleAdapter
        }
    }
}
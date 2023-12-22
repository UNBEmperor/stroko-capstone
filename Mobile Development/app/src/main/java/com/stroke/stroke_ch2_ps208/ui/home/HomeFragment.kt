package com.stroke.stroke_ch2_ps208.ui.home

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.stroke.stroke_ch2_ps208.databinding.FragmentHomeBinding
import com.stroke.stroke_ch2_ps208.domain.enity.ListArticle
import com.stroke.stroke_ch2_ps208.ui.ViewModelFactory
import com.stroke.stroke_ch2_ps208.ui.ambulance.AmbulanceActivity
import com.stroke.stroke_ch2_ps208.ui.article.ArticleActivity
import com.stroke.stroke_ch2_ps208.ui.comunitystorke.ComunityStrokeActivity
import com.stroke.stroke_ch2_ps208.ui.detail.DetailsArticleActivity
import com.stroke.stroke_ch2_ps208.ui.foodrecomendation.FoodRecomendationActivity
import com.stroke.stroke_ch2_ps208.ui.healthy.HealthyLifestyleActivity
import com.stroke.stroke_ch2_ps208.ui.home.adapter.GridArticleAdapter
import com.stroke.stroke_ch2_ps208.ui.home.adapter.PromoAdapter
import com.stroke.stroke_ch2_ps208.ui.strokedetection.StrokeDetectionActivity
import com.stroke.stroke_ch2_ps208.utils.DummyData
import com.stroke.stroke_ch2_ps208.utils.snapScroll

class HomeFragment : Fragment(),GridArticleAdapter.ArticleClickCallback{
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val promoAdapter = PromoAdapter()
    lateinit var factory: ViewModelFactory
    private val viewModel: HomeViewModel by viewModels { factory }
    private val gridArticleAdapter = GridArticleAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkIfFragmentAttached {
        }
        initView()
        displayTextOneByOne()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initView() = with(binding) {
        initRv()

        seeAll.setOnClickListener {
            val intent = Intent(requireContext(), ArticleActivity::class.java)
            startActivity(intent)
        }

        with(vMenu) {
            strokeDecetionFitur.setOnClickListener {
                val intent = Intent(requireContext(), StrokeDetectionActivity::class.java)
                startActivity(intent)
            }
            foodRecomendationFitur.setOnClickListener {
                val intent = Intent(requireContext(), FoodRecomendationActivity::class.java)
                startActivity(intent)
            }
            articleFitur.setOnClickListener {
                val intent = Intent(requireContext(), ArticleActivity::class.java)
                startActivity(intent)
            }
            healthyLifestyle.setOnClickListener {
                val intent = Intent(requireContext(), HealthyLifestyleActivity::class.java)
                startActivity(intent)
            }
            communityStroke.setOnClickListener {
                try {
                    val telegramUri = Uri.parse("https://t.me/+wF99V-OTgZQ0Yjdl")
                    val telegramIntent = Intent(Intent.ACTION_VIEW, telegramUri)
                    startActivity(telegramIntent)
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(requireContext(), "Aplikasi Telegram tidak terinstal", Toast.LENGTH_SHORT).show()
                }
            }
            ambulance.setOnClickListener {
                val intent = Intent(requireContext(), AmbulanceActivity::class.java)
                startActivity(intent)
            }
            rvArticle.setOnClickListener {
                val intent = Intent(requireContext(), HomeFragment::class.java)
                startActivity(intent)
            }
        }
    }

    private fun initRv() {
        DummyData.apply {
            promoAdapter.setData(providePromos())
            val strokeArticles = provideStrokeArticles().take(5)
            gridArticleAdapter.setData(strokeArticles)
        }

        with(binding.rvPromo) {
            adapter = promoAdapter
            layoutManager =
                FlexboxLayoutManager(requireContext(), FlexDirection.ROW, FlexWrap.NOWRAP)
            snapScroll()
            val handler = Handler(Looper.getMainLooper()).postDelayed({
                post(Runnable {
                    smoothScrollToPosition(1)
                })
            }, ANIMATION_DELAY)
        }

        with(binding.rvArticle) {
            adapter = gridArticleAdapter
            layoutManager =
                FlexboxLayoutManager(requireContext(), FlexDirection.ROW, FlexWrap.NOWRAP)
            snapScroll()
        }
    }


    private fun displayTextOneByOne() {
        val originalText = "STROKO: Strike Out Stroke!"
        val handler = Handler(Looper.getMainLooper())

        var index = 0
        var isReversed = false

        val delayMillis = 300

        handler.post(object : Runnable {
            override fun run() {
                val currentBinding = _binding
                if (currentBinding != null) {
                    if (!isReversed && index < originalText.length) {
                        val newText = originalText.substring(0, index + 1)
                        currentBinding.textView4.text = newText
                        index++
                    } else if (index > 0) {
                        isReversed = true
                        val newText = originalText.substring(0, index - 1)
                        currentBinding.textView4.text = newText
                        index--
                    } else {
                        isReversed = false
                    }

                    handler.postDelayed(this, delayMillis.toLong())
                }
            }
        })
    }
    private fun checkIfFragmentAttached(operations: Context.() -> Unit) {
        if (isAdded && context != null) {
            operations(requireContext())
        }
    }
    override fun onClickArticle(article: ListArticle) {
        val detailIntent = Intent(requireActivity(), DetailsArticleActivity::class.java)
        detailIntent.putExtra("selected_article", article)
        startActivity(detailIntent)
    }

    companion object {
        const val ANIMATION_DELAY = 2000L
    }
}
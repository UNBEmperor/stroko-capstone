package com.stroke.stroke_ch2_ps208.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stroke.stroke_ch2_ps208.R
import com.stroke.stroke_ch2_ps208.data.network.response.ArticleData
import com.stroke.stroke_ch2_ps208.databinding.ItemGridArtikelBinding
import com.stroke.stroke_ch2_ps208.domain.enity.ListArticle
import com.stroke.stroke_ch2_ps208.utils.loadImage
import com.stroke.stroke_ch2_ps208.utils.setMargin



class GridArticleAdapter(private val callback: ArticleClickCallback) :
    RecyclerView.Adapter<GridArticleAdapter.ViewHolder>() {

    private val items = ArrayList<ListArticle>()


    fun setData(data: List<ListArticle>) {
        items.addAll(data)
        notifyDataSetChanged()
    }

    interface ArticleClickCallback {
        fun onClickArticle(article: ListArticle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemGridArtikelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position], position)

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemGridArtikelBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ListArticle, position: Int) {
            itemView.layoutParams.apply {
                when (position) {
                    0 -> setMargin(32, 16)
                    itemCount - 1 -> setMargin(0, 32)
                    else -> setMargin(0, 16)
                }
            }

            with(binding) {
                tvTitle.text = item.name
                imgBarber.loadImage(item.imageUrl)
                tvPenerbit.text = item.description
                tvDate.text = item.publishDate
                root.setOnClickListener { callback.onClickArticle(item) }

                imgFavorite.setOnClickListener {
                    item.isFavorite = !item.isFavorite
                    if (item.isFavorite) {
                        imgFavorite.setImageResource(R.drawable.baseline_favorite_24)
                    } else {
                        imgFavorite.setImageResource(R.drawable.ic_favorite_border)
                    }
                }
            }
        }
    }
}

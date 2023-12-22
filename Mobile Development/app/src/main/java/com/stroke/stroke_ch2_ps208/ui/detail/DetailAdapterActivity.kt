package com.stroke.stroke_ch2_ps208.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stroke.stroke_ch2_ps208.databinding.ItemListArticleBinding
import com.stroke.stroke_ch2_ps208.domain.enity.ListArticle
import com.stroke.stroke_ch2_ps208.utils.loadImage

class DetailAdapterArticle(private val onItemClick: (View, ListArticle) -> Unit) :
    RecyclerView.Adapter<DetailAdapterArticle.ViewHolder>() {
    private val listArticle = ArrayList<ListArticle>()

    fun setData(items: List<ListArticle>) {
        listArticle.clear()
        listArticle.addAll(items)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: DetailAdapterArticle.ViewHolder, position: Int) =
        holder.bind(listArticle[position])

    override fun getItemCount() = listArticle.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemListArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    inner class ViewHolder(private val binding: ItemListArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListArticle) = with(binding) {
            imgNotif.loadImage(item.imageUrl)
            tvTitle.text = item.name
            tvDeskripsi.text = item.description
            tvDate.text = item.publishDate

            imgBookmark.setOnClickListener {
                onItemClick.invoke(it, item)
            }
            root.setOnClickListener {
                onItemClick.invoke(it, item)
            }
        }
    }
}
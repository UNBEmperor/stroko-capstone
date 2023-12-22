package com.stroke.stroke_ch2_ps208.ui.article

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stroke.stroke_ch2_ps208.databinding.ItemListArticleBinding
import com.stroke.stroke_ch2_ps208.domain.enity.ListArticle
import com.stroke.stroke_ch2_ps208.ui.detail.DetailsArticleActivity
import com.stroke.stroke_ch2_ps208.utils.loadImage

class AdapterArticle(private val onItemClick: (View, ListArticle) -> Unit) :
    RecyclerView.Adapter<AdapterArticle.ViewHolder>() {
    private val listArticle = ArrayList<ListArticle>()

    fun setData(items: List<ListArticle>) {
        listArticle.clear()
        listArticle.addAll(items)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: AdapterArticle.ViewHolder, position: Int) =
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
                val context = itemView.context
                val detailIntent = Intent(context, DetailsArticleActivity::class.java)
                detailIntent.putExtra("selected_article", item)
                context.startActivity(detailIntent)
            }
        }
    }
}
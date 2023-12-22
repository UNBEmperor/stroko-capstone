package com.stroke.stroke_ch2_ps208.ui.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stroke.stroke_ch2_ps208.R
import com.stroke.stroke_ch2_ps208.databinding.ItemNotificationBinding
import com.stroke.stroke_ch2_ps208.domain.enity.Notification

class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {
    private val notifications = ArrayList<Notification>()

    fun setData(items: List<Notification>) {
        notifications.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(notifications[position])

    override fun getItemCount() = notifications.size

    inner class ViewHolder(private val binding: ItemNotificationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(notification: Notification) {
            with(binding) {
                tvTitle.text = notification.name
                tvDesc.text = notification.description
                when (notification.type) {
                    0 -> imgNotif.setImageResource(R.drawable.notif03)
                    1 -> imgNotif.setImageResource(R.drawable.notif02)
                    2 -> imgNotif.setImageResource(R.drawable.notif01)
                    else -> imgNotif.setImageResource(R.drawable.placeholder)
                }
            }
        }
    }
}
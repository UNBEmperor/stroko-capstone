package com.stroke.stroke_ch2_ps208.ui.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.stroke.stroke_ch2_ps208.databinding.FragmentNotificationBinding
import com.stroke.stroke_ch2_ps208.utils.DummyData
import com.stroke.stroke_ch2_ps208.utils.MarginItemDecoration

class NotificationFragment : Fragment() {
    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!
    private val notificationTodayAdapter = NotificationAdapter()
    private val notificationYesterdayAdapter = NotificationAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() = with(binding) {
        initRv()
    }

    private fun initRv() {
        DummyData.provideNotifications().apply {
            notificationTodayAdapter.setData(this)
            notificationYesterdayAdapter.setData(this)
        }

        val decoration = MarginItemDecoration(20)

        with(binding.rvToday) {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(decoration)
            adapter = notificationTodayAdapter
        }

        with(binding.rvYesterday) {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(decoration)
            adapter = notificationYesterdayAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

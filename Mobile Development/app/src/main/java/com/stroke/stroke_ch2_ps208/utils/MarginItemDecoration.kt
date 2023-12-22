package com.stroke.stroke_ch2_ps208.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(spaceHeight: Int, private val orientation: Int = LinearLayoutManager.VERTICAL) :
    RecyclerView.ItemDecoration() {
    private val spacing = spaceHeight.toDp()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            if(orientation == LinearLayoutManager.VERTICAL) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    top = spacing
                }
                left = spacing
                right = spacing
                bottom = spacing
            }else{
                left = if (parent.getChildAdapterPosition(view) == 0) {
                    spacing * 2
                }else {
                    spacing
                }
                right = if (parent.getChildAdapterPosition(view) == 4) {
                    spacing * 2
                } else {
                    spacing
                }
            }
        }
    }
}

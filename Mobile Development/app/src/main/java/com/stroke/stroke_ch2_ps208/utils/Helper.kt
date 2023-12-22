package com.stroke.stroke_ch2_ps208.utils

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.razir.progressbutton.attachTextChangeAnimator
import com.github.razir.progressbutton.bindProgressButton
import com.github.razir.progressbutton.showProgress
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexboxLayoutManager
import com.stroke.stroke_ch2_ps208.R

fun RecyclerView.snapScroll() {
    val pagerSnapHelper = PagerSnapHelper()
    pagerSnapHelper.attachToRecyclerView(this)
}

fun AppCompatButton.showLoading(lifecycleOwner: LifecycleOwner) {
    lifecycleOwner.bindProgressButton(this)
    attachTextChangeAnimator()
    showProgress {
        buttonTextRes = R.string.loading
        progressColor = Color.WHITE
    }
    isEnabled = false
}

fun ImageView.loadImage(url: String?) {
    Glide.with(this.context)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.placeholder)
        .into(this)
}

fun Activity.closeKeyboard() {
    val view = this.currentFocus
    if (view != null) {
        val imm: InputMethodManager? =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }
}


fun Int.toDp() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun ViewGroup.LayoutParams.setMargin(start: Int, end: Int) {
    with(this) {
        if (this is FlexboxLayoutManager.LayoutParams) {
            flexShrink = 0.0f
            alignSelf = AlignItems.FLEX_START
            marginStart = start.toDp()
            marginEnd = end.toDp()
        }
    }
}

fun Context.showToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

package com.stroke.stroke_ch2_ps208.utils

import android.animation.ObjectAnimator
import android.view.View

fun View.animateVisibility(isVisible: Boolean, duration: Long = 400) {
    ObjectAnimator
        .ofFloat(this, View.ALPHA, if (isVisible) 1f else 0f)
        .setDuration(duration)
        .start()
}
fun View.isVisible() = this.visibility == View.VISIBLE


object Extra {
    const val EXTRA_TOKEN = "extra_token"

}
package com.ktknahmet.mobilium.utils.recyclerview

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ktknahmet.mobilium.utils.recyclerview.RvConstants.DOUBLE_TAP
import com.ktknahmet.mobilium.utils.recyclerview.RvConstants.LONG_PRESS
import com.ktknahmet.mobilium.utils.recyclerview.RvConstants.SINGLE_TAP_UP

class GestureListener(
    private val recyclerView: RecyclerView,
    private val listener: (View, Int) -> Unit,
    private val type: Int
) : GestureDetector.SimpleOnGestureListener() {

    override fun onSingleTapUp(e: MotionEvent): Boolean = e.getChild(SINGLE_TAP_UP) ?: true

    override fun onDoubleTap(e: MotionEvent): Boolean = e.getChild(DOUBLE_TAP) ?: true

    override fun onLongPress(e: MotionEvent) {
        e.getChild(LONG_PRESS)
    }

    private fun MotionEvent.getChild(t: Int): Boolean {
        recyclerView.findChildViewUnder(x, y)?.let {
            if (type == t)
                listener(it, recyclerView.getChildAdapterPosition(it))
        }
        return true
    }
}

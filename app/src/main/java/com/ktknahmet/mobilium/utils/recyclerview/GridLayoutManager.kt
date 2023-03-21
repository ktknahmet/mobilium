@file:Suppress("unused")

package com.ktknahmet.mobilium.utils.recyclerview

import android.content.Context
import androidx.annotation.IntegerRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ktknahmet.mobilium.utils.generalUtils.int

inline fun gridLayoutManager(
    spanCount: Int,
    reverseLayout: Boolean = false,
    setup: GridLayoutManager.() -> Unit = {}
) = GridLayoutManager(null, spanCount, RecyclerView.VERTICAL, reverseLayout).apply(setup)

inline fun gridLayoutManager(
    context: Context,
    @IntegerRes spanCountRes: Int,
    reverseLayout: Boolean = false,
    setup: GridLayoutManager.() -> Unit = {}
) = gridLayoutManager(context.int(spanCountRes), reverseLayout, setup)

inline fun horizontalGridLayoutManager(
    spanCount: Int,
    reverseLayout: Boolean = false,
    setup: GridLayoutManager.() -> Unit = {}
) = GridLayoutManager(null, spanCount, RecyclerView.HORIZONTAL, reverseLayout).apply(setup)

inline fun horizontalGridLayoutManager(
    context: Context,
    @IntegerRes spanCountRes: Int,
    reverseLayout: Boolean = false,
    setup: GridLayoutManager.() -> Unit = {}
) = horizontalGridLayoutManager(context.int(spanCountRes), reverseLayout, setup)

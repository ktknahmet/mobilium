package com.ktknahmet.mobilium.utils.recyclerview

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

inline fun verticalLayoutManager(
    reverseLayout: Boolean = false,
    setup: LinearLayoutManager.() -> Unit = {}
) = LinearLayoutManager(null, RecyclerView.VERTICAL, reverseLayout).apply(setup)

inline fun horizontalLayoutManager(
    reverseLayout: Boolean = false,
    setup: LinearLayoutManager.() -> Unit = {}
) = LinearLayoutManager(null, RecyclerView.HORIZONTAL, reverseLayout).apply(setup)

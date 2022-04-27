package com.engamsba.noteapplication.utils

import android.view.View

interface OnClickItemVMListener<T> {
    fun onClickItemRecyclerView(data: T, position: Int, view: View)
}
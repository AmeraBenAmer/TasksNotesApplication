package com.engamsba.noteapplication.ui.base

import android.icu.text.CaseMap
import android.widget.Toolbar

interface BaseToolbar {
    fun setToolBar(toolbar: Toolbar)
    fun showToolbar(show: Boolean)
    fun setToolbarTitle(title: String)
    fun setLayoutDirectionLocal()
}
package com.engamsba.noteapplication.utils

import android.os.SystemClock
import android.view.View

class OnOneOffClickListener(private var defualtInterval: Int = 1000,
                            private val onSafeClick: (View) -> Unit) : View.OnClickListener{

    private var lastTimeClicked: Long = 0
    override fun onClick(view: View?) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked< defualtInterval)
            return
        lastTimeClicked = SystemClock.elapsedRealtime()
        onSafeClick(view!!)
    }

}
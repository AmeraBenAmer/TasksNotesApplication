package com.engamsba.noteapplication.ui.base

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.engamsba.noteapplication.viewmodel.BaseViewModel


abstract class BaseDialog<T: ViewDataBinding, VM: BaseViewModel> : DialogFragment() {

    private var baseActivity: BaseActivity<*, *>? = null
    private var mRootView: View? = null
    var viewDataBinding: T? = null
        private set

    @get:LayoutRes
    abstract val layout: Int

    abstract val viewModel: VM


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is BaseActivity<*, *>) {
            val activity = context
            baseActivity = activity
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL,
            android.R.style.Theme_NoTitleBar_Fullscreen)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate<T>(inflater, layout, container, false)

        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
//        if (this is CustomLoaderDialog)
//            dialog?.window?.setGravity(Gravity.CENTER)
//        else
            dialog?.window?.setGravity(Gravity.BOTTOM)
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
//        if ((this is CustomLoaderDialog))
//            dialog?.window?.attributes!!.windowAnimations = R.style.DialogAnimationwithFade
//        else
//            dialog?.window?.attributes!!.windowAnimations = R.style.DialogAnimationfrombootom
//        isCancelable = false

         mRootView = viewDataBinding!!.root
        return mRootView
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding!!.lifecycleOwner = this
    }

//    fun showLoader(show: Boolean) {
//        if (activity is BaseActivity<*, *>) {
//            (activity as BaseActivity<*, *>).showLoader(show)
//        }
//    }

}
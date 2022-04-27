package com.engamsba.noteapplication.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.engamsba.noteapplication.utils.OnOneOffClickListener
import com.engamsba.noteapplication.viewmodel.BaseViewModel

abstract class BaseFragment<T : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    private lateinit var mViewDataBinding : T
    var mActivity : BaseActivity<T, VM>? = null

    //manage toolbar
    lateinit var toolbar : BaseToolbar

    /**
     * @return layout resource id
     */
    @get:LayoutRes
    protected abstract val layout : Int

    var baseActivity : BaseActivity<T, VM>? = null
    private set

    private var mRootView: View? = null

    var binding: T? = null
    private set

    abstract val viewModel: VM

    abstract fun initDataBinding()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        mRootView = binding!!.root
        binding!!.lifecycleOwner = this

        initDataBinding()
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewDataBinding = binding!!
        mViewDataBinding.lifecycleOwner = this
        mViewDataBinding.executePendingBindings()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*,*>){
            mActivity = context as BaseActivity<T, VM>?
        }
        if (activity is BaseToolbar)
            toolbar = activity as BaseToolbar

    }

    override fun onDetach() {
        super.onDetach()
        mActivity = null
    }

    fun hideKeyboard() = mActivity?.hideKeyboard()

    fun showMessage(message: String) = mActivity?.showMessage(message)

    /**
     * prevent double click on view
     **/
    fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
        try {
            val safeClickListener = OnOneOffClickListener {
                onSafeClick(it)
            }
            setOnClickListener(safeClickListener)
        } catch (E: Exception) {
        }
    }

    fun changeStatusBarColor(color: Int?){
        (activity as BaseActivity<*,*>).updateStatusBarColor(color)
    }



}
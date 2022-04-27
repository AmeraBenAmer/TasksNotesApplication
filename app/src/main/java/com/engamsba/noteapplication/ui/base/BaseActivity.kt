package com.engamsba.noteapplication.ui.base

import android.annotation.TargetApi
import android.app.Dialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.engamsba.noteapplication.R
import com.engamsba.noteapplication.utils.OnOneOffClickListener
import com.engamsba.noteapplication.viewmodel.BaseViewModel

abstract class BaseActivity<out T: ViewDataBinding, VM: BaseViewModel>: AppCompatActivity() {

    var mProgressDoalog : Dialog? = null

    abstract fun initDataBinding()


    /**
     * @return layout to setup data binding.
     */
    @get:LayoutRes
    protected abstract  val layout: Int

    abstract val viewModel: VM

    private lateinit var mViewDataBinding: T

    val binding by lazy {
        DataBindingUtil.setContentView(this, layout) as T
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
    }

    fun hideKeyboard(){
        //check if no view has focus:
        val view =  this.currentFocus
        if (view != null){
            val inputManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)

        }
    }
    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermesion(permission: String): Boolean{
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }


    @TargetApi(Build.VERSION_CODES.M)
    fun requestPremeisionSafely(permission: Array<String>, requestCode: Int){
        requestPermissions(permission, requestCode)
    }

    fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit){
        try {
            val safeClickListener = OnOneOffClickListener{ view->
                onSafeClick(view)
            }
            setOnClickListener(safeClickListener)

        }catch (E: Exception){

        }
    }

    fun showMessage(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    /**
     * change color of status bar
     * @param color
     */

    fun updateStatusBarColor(color: Int?){
        val window: Window = window
        window.run {
            if (color == R.color.white)
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            else
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        }
    }
}
package com.engamsba.noteapplication.ui.activity

import android.os.Bundle
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.engamsba.noteapplication.BR
import com.engamsba.noteapplication.R
import com.engamsba.noteapplication.databinding.ActivityMainBinding
import com.engamsba.noteapplication.ui.base.BaseActivity
import com.engamsba.noteapplication.ui.base.BaseToolbar
import com.engamsba.noteapplication.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity(override val layout: Int = R.layout.activity_main)
    : BaseActivity<ActivityMainBinding, MainViewModel>(), BaseToolbar {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override val viewModel: MainViewModel by viewModels()

    private lateinit var activityMainBinding: ActivityMainBinding
    private var toolbarMain : Toolbar? = null

    override fun initDataBinding() {
        binding.setVariable(BR.viewModel, viewModel)
    }

//    private val navController: NavController by lazy {
//        Navigation.findNavController(
//            this,
//                R.id.nav_host_fragment
//        )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = binding
        binding.lifecycleOwner = this

        val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
                        ?: return

        with(navHostFragment.navController) {
            appBarConfiguration = AppBarConfiguration(graph)
            setupActionBarWithNavController(this, appBarConfiguration)
        }
        // setUp bottom navigation
        NavigationUI.setupWithNavController(binding.bottomNavigation, navHostFragment.navController)


    }

    override fun setToolBar(toolbar: Toolbar) {
       // setToolBar(bin)
    }

    override fun showToolbar(show: Boolean) {
        TODO("Not yet implemented")
    }

    override fun setToolbarTitle(title: String) {
        TODO("Not yet implemented")
    }

    override fun setLayoutDirectionLocal() {
        TODO("Not yet implemented")
    }
}
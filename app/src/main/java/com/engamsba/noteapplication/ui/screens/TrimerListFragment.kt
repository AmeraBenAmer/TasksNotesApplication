package com.engamsba.noteapplication.ui.screens

import androidx.fragment.app.viewModels
import com.engamsba.noteapplication.BR
import com.engamsba.noteapplication.R
import com.engamsba.noteapplication.databinding.AllTimerFragmentBinding
import com.engamsba.noteapplication.ui.base.BaseFragment
import com.engamsba.noteapplication.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TrimerListFragment(override val layout: Int = R.layout.all_timer_fragment)
    :BaseFragment<AllTimerFragmentBinding, MainViewModel>()
{

    override val viewModel : MainViewModel by viewModels()

    override fun initDataBinding() {

        binding!!.setVariable(BR._all, viewModel)

    }

}
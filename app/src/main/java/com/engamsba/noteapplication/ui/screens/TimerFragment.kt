package com.engamsba.noteapplication.ui.screens

import androidx.fragment.app.viewModels
import com.engamsba.noteapplication.BR
import com.engamsba.noteapplication.R
import com.engamsba.noteapplication.databinding.TimerFragmentBinding
import com.engamsba.noteapplication.ui.base.BaseFragment
import com.engamsba.noteapplication.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TimerFragment(override val layout: Int = R.layout.timer_fragment)
    :BaseFragment<TimerFragmentBinding, MainViewModel>()
{

    override val viewModel : MainViewModel by viewModels()

    override fun initDataBinding() {

        binding!!.setVariable(BR._all, viewModel)

    }

}
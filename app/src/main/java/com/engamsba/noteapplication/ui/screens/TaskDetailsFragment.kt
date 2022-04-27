package com.engamsba.noteapplication.ui.screens

import androidx.fragment.app.viewModels
import com.engamsba.noteapplication.BR
import com.engamsba.noteapplication.R
import com.engamsba.noteapplication.databinding.DetailsTaskFragmentBinding
import com.engamsba.noteapplication.ui.base.BaseFragment
import com.engamsba.noteapplication.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TaskDetailsFragment (override val layout: Int = R.layout.details_task_fragment)
    : BaseFragment<DetailsTaskFragmentBinding, MainViewModel>() {

    override val viewModel : MainViewModel by viewModels()

    override fun initDataBinding() {
        binding!!.setVariable(BR._all, viewModel)
    }
}
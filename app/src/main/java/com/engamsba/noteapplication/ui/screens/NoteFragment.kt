package com.engamsba.noteapplication.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.engamsba.noteapplication.BR
import com.engamsba.noteapplication.R
import com.engamsba.noteapplication.databinding.NotesFragmentBinding
import com.engamsba.noteapplication.ui.base.BaseFragment
import com.engamsba.noteapplication.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NoteFragment(override val layout: Int = R.layout.notes_fragment)
    :BaseFragment<NotesFragmentBinding, MainViewModel>() {
        override val viewModel: MainViewModel by viewModels()

    override fun initDataBinding() {
        binding!!.setVariable(BR._all, viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
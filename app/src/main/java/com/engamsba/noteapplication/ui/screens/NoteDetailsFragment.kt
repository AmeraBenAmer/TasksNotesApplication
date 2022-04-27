package com.engamsba.noteapplication.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.engamsba.noteapplication.BR
import com.engamsba.noteapplication.R
import com.engamsba.noteapplication.databinding.DetailsNoteFragmentBinding
import com.engamsba.noteapplication.db.entity.Categories
import com.engamsba.noteapplication.ui.ViewState
import com.engamsba.noteapplication.ui.base.BaseFragment
import com.engamsba.noteapplication.utils.toast
import com.engamsba.noteapplication.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import android.widget.ArrayAdapter





@AndroidEntryPoint
class NoteDetailsFragment(override val layout: Int = R.layout.details_note_fragment)
    : BaseFragment<DetailsNoteFragmentBinding, MainViewModel>() , View.OnClickListener{

        override val viewModel : MainViewModel by viewModels()
    override fun initDataBinding() {
        binding!!.setVariable(BR._all, viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewDropDowMenu(uiState.categories)
        onClickListener()
    }

    fun initViewDropDowMenu(categories: List<Categories>) {
        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(requireContext(), R.layout.item_category )
        binding?.autoTextViewCategories?.setAdapter(adapter);
        binding?.autoTextViewCategories?.setOnItemClickListener(this@);
    }
    private fun onClickListener(){
        binding?.apply {
            imageViewAddCategory.setOnClickListener(this@NoteDetailsFragment)
            buttonAddNote.setOnClickListener(this@NoteDetailsFragment)
            colorLayoutSelection.viewColorGreen.setOnClickListener(this@NoteDetailsFragment)
            colorLayoutSelection.viewColorGreen2.setOnClickListener(this@NoteDetailsFragment)
            colorLayoutSelection.viewColorGreenBlue.setOnClickListener(this@NoteDetailsFragment)
            colorLayoutSelection.viewColorPerlple.setOnClickListener(this@NoteDetailsFragment)
            colorLayoutSelection.viewColorYellow.setOnClickListener(this@NoteDetailsFragment)
            colorLayoutSelection.viewColorRed.setOnClickListener(this@NoteDetailsFragment)
        }

    }
    private fun observeNotes() {

        // This will block will run on started state & will suspend when view moves to stop state
        this.lifecycleScope.launchWhenStarted {
            // Triggers the flow and starts listening for values
            viewModel.uiState.collect { uiState ->
                when (uiState) {
                    is ViewState.Loading -> {
                        //binding.progress.show()
                    }
                    is ViewState.Succuss<Categories> -> {
                        ////binding.progress.hide()
                        initViewDropDowMenu(uiState.categories)
                    }
                    is ViewState.Error -> {
//                        binding.progress.hide()
//                        requireActivity().toast("Error...")
                    }
                    is ViewState.Empty -> {
//                        binding.progress.hide()
//                        showEmptyState()
                    }
                }
            }
        }

    }
    override fun onClick(v: View?) {
        binding?.apply {
            when(v){
                imageViewAddCategory ->{
                    findNavController().navigate(NoteDetailsFragmentDirections.actionNoteDetailsFragmentToAddCategoryDialog())
                }
                buttonAddNote ->{
                    if(textViewNoteTitle.text!!.isEmpty()){
                        requireActivity().toast(getString(R.string.lbl_empty_name))
                    } else{
    //                        viewModel.insertCategory(nameCatedgories).also {
    //                            requireActivity().toast(getString(R.string.lbl_save_name))
    //                            // Go back
    //                            NavHostFragment.findNavController(this).navigateUp()
    //                        }
                    }

                }

            }
        }

    }
}
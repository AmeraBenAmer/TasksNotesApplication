package com.engamsba.noteapplication.ui.screens

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.engamsba.noteapplication.R
import com.engamsba.noteapplication.databinding.AddCategoriesDialogBinding
import com.engamsba.noteapplication.ui.base.BaseDialog
import com.engamsba.noteapplication.utils.toast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddCategoryDialog(override val layout : Int = R.layout.add_categories_dialog)
    : BaseDialog<AddCategoriesDialogBinding, CategoryViewModel>(), View.OnClickListener{


    override val viewModel: CategoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        dialog?.window?.setGravity(Gravity.BOTTOM)
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)

        onClickListener()

    }

    private fun onClickListener(){
        viewDataBinding?.textViewConfirm?.setOnClickListener(this)
    }

    private fun getCategoryContent() =
        viewDataBinding?.nameCategoryEditText!!.text.toString()

    override fun onClick(p0: View?) {
        val nameCatedgories = getCategoryContent()

        when(p0){
            viewDataBinding?.textViewConfirm->{
                when{
                    nameCatedgories.isEmpty() -> {
                        requireActivity().toast(getString(R.string.lbl_empty_name))
                    }
                    else -> {
                        viewModel.insertCategory(nameCatedgories).also {
                            requireActivity().toast(getString(R.string.lbl_save_name))
                            // Go back
                              NavHostFragment.findNavController(this).navigateUp()
                        }
                    }
                }
            }
        }
    }

    /* private fun getCategoryContent() = Pair(
         binding?.nameCategoryEditText!!.text.toString(),
         binding?.nameCategoryEditText!!.text.toString()
     )*/


}
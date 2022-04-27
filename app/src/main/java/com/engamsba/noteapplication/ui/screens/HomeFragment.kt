 package com.engamsba.noteapplication.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.engamsba.noteapplication.BR
import com.engamsba.noteapplication.R
import com.engamsba.noteapplication.databinding.HomeFragmentBinding
import com.engamsba.noteapplication.db.entity.Categories
import com.engamsba.noteapplication.models.CategoryModel
import com.engamsba.noteapplication.ui.ViewState
import com.engamsba.noteapplication.ui.adapter.CategoryAdapter
import com.engamsba.noteapplication.ui.base.BaseFragment
import com.engamsba.noteapplication.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect


 @AndroidEntryPoint
class HomeFragment(override val layout: Int = R.layout.home_fragment)
    : BaseFragment<HomeFragmentBinding, MainViewModel>(),
        View.OnClickListener,
        CategoryModel.CategoryItemClick {

    override val viewModel : MainViewModel by viewModels()
     var allCategories:  List<Categories> = listOf()

    private val categoriesAdapter by lazy {
        CategoryAdapter(arrayListOf(), this)
    }

    override fun initDataBinding() {
        binding!!.setVariable(BR.viewModel, viewModel)
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
                        onCategoryLoaded(uiState.categories)
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

    private fun onCategoryLoaded(categories: List<Categories>){
      //  binding.emptyStateLayout.hide()
        categoriesAdapter.submitList(categories)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


         setOnClickListener()

        setupRecyclerView()
        observeNotes()
    }

    private fun setupRecyclerView(){
        //categoriesAdapter = CategoryAdapter(allCategories, this)
        binding?.recyclerViewTodayTask?.apply {
            adapter = categoriesAdapter
            layoutManager = LinearLayoutManager(requireActivity())
            //this.setHasFixedSize(true)
        }
    }

    private fun setOnClickListener(){
       // binding?.addNewCategoryBtn!!.setOnClickListener(this)
    }
    override fun onClick(view: View?) {
        when(view){
//            binding?.addNewCategoryBtn -> {
//                Log.e("onClick", "onClick: addNewCategoryBtn", )
//                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAddCategoryDialog())
//            }
        }

    }


    override fun onItemClick(categories: Categories) {
        TODO("Not yet implemented")
    }

}
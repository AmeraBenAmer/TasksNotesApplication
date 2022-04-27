package com.engamsba.noteapplication.ui.adapter

import BaseDiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.engamsba.noteapplication.databinding.ItemCategoriesBinding
import com.engamsba.noteapplication.db.entity.Categories
import com.engamsba.noteapplication.models.CategoryModel
import com.engamsba.noteapplication.ui.base.BaseViewHolder
import com.engamsba.noteapplication.ui.screens.HomeFragment

class CategoryAdapter(
    var list: List<Categories>, var listener: CategoryModel.CategoryItemClick
)  : RecyclerView.Adapter<BaseViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = ItemCategoriesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return CategoriesViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    inner class CategoriesViewHolder(val binding: ItemCategoriesBinding?):
            BaseViewHolder(binding?.root){
        private lateinit var categoryModel: CategoryModel

        override fun onBind(position: Int) {
                val calegory = list[position]
                categoryModel = CategoryModel(calegory, listener)
                binding!!.viewModel = categoryModel
        }
            }

    fun submitList(_list: List<Categories>) {
        val diffUtil = BaseDiffUtil(list, _list)
        val differResult = DiffUtil.calculateDiff(diffUtil)
        list = _list
        differResult.dispatchUpdatesTo(this)
    }
}
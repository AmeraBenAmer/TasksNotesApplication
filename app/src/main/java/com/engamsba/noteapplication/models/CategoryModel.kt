package com.engamsba.noteapplication.models

import androidx.lifecycle.MutableLiveData
import com.engamsba.noteapplication.db.entity.Categories

class CategoryModel(var categories: Categories, var mListener: CategoryItemClick){

    var imageUrl = MutableLiveData<String>()
    var name = MutableLiveData<String>()

    init {
        imageUrl.value = categories.iconCategories
        name.value = categories.nameCategories
    }

    fun onClickItem(){
        mListener.onItemClick(categories = categories)
    }

    interface CategoryItemClick{
        fun onItemClick(categories: Categories)
    }
}

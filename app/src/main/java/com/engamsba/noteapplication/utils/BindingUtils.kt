package com.engamsba.noteapplication.utils


import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.engamsba.noteapplication.db.entity.Categories
import com.engamsba.noteapplication.ui.adapter.CategoryAdapter


@BindingAdapter("adapter")
fun addCategoriesItems(recyclerView: RecyclerView, categories: ArrayList<Categories>?) {
    val adapter = recyclerView.adapter as? CategoryAdapter
    //adapter?.clearItems()
    adapter?.submitList(categories!!)
}

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    val context = imageView.context
   // if (url != null)
       // Glide.with(context).load(url).into(imageView)
}

@BindingAdapter("settext")
fun settext(textView: TextView, text: String?) {
    val context = textView.context
    if (text != null)
        textView.text = text
}





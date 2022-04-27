package com.engamsba.noteapplication.viewmodel

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.engamsba.noteapplication.db.entity.Categories
import com.engamsba.noteapplication.repository.MainRepository
import com.engamsba.noteapplication.ui.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject internal constructor(
    application: Application,
    private val mainRepo : MainRepository
) :BaseViewModel() {
    private val _uiState = MutableStateFlow<ViewState<Categories>>(ViewState.Loading)

    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            mainRepo.getAllCategories().distinctUntilChanged().collect {
                if (it.isNullOrEmpty()){
                    _uiState.value = ViewState.Empty
                }else{
                    _uiState.value = ViewState.Succuss(it)
                }
            }
        }
    }
    fun insertCategory(name: String) = this.viewModelScope.launch {
        val category = Categories(
                nameCategories = name
        )
        mainRepo.insert(category)
    }

}
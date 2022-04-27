package com.engamsba.noteapplication.ui


sealed class ViewState<out T: Any> {
    object Empty:  ViewState<Nothing>()
    object Loading:  ViewState<Nothing>()
    data class Succuss<T: Any>(val categories: List<T>): ViewState<T>()
    data class Error(val exception : Throwable): ViewState<Nothing>()
}
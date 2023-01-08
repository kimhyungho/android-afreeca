package com.hardy.afreeca.databinding

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingAdapter("refreshing")
fun SwipeRefreshLayout.bindRefreshing(isRefreshing: Boolean){
    setRefreshing(isRefreshing)
}
package com.hardy.afreeca.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hardy.domain.interactors.broadcategory.GetBroadCategoryListUseCase
import com.hardy.domain.model.BroadCategory
import com.hardy.domain.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getBroadCategoryListUseCase: GetBroadCategoryListUseCase
) : ViewModel() {
    private val _getBroadCategoriesLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val getBroadCategoriesLoading: StateFlow<Boolean> = _getBroadCategoriesLoading

    private val _broadCategories: MutableStateFlow<List<BroadCategory>> = MutableStateFlow(listOf())
    val broadCategories: StateFlow<List<BroadCategory>> = _broadCategories

    private val _hasError: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val hasError: StateFlow<Boolean> = _hasError

    init {
        fetchBroadCategories()
    }

    fun fetchBroadCategories() = viewModelScope.launch(Dispatchers.IO) {
        getBroadCategoryListUseCase()
            .collect { response ->
                when (response) {
                    is Response.Loading -> {
                        _getBroadCategoriesLoading.value = true
                        _hasError.value = false
                    }

                    is Response.Success -> {
                        _getBroadCategoriesLoading.value = false
                        _hasError.value = false
                        _broadCategories.value = response.data ?: listOf()
                    }

                    is Response.Failure -> {
                        _getBroadCategoriesLoading.value = false
                        _hasError.value = true
                    }
                }
            }
    }
}
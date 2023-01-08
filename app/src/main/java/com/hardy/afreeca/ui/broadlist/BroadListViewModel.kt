package com.hardy.afreeca.ui.broadlist


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hardy.domain.interactors.broad.GetBroadListUseCase
import com.hardy.domain.interactors.broadcategory.GetBroadCategoryListUseCase
import com.hardy.domain.model.Broad
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BroadListViewModel @Inject constructor(
    private val getBroadListUseCase: GetBroadListUseCase
) : ViewModel() {
    private val _broads: MutableStateFlow<PagingData<Broad>> = MutableStateFlow(PagingData.empty())
    val broads: StateFlow<PagingData<Broad>> = _broads

    private val _isRefreshing: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    fun getBroadList(selectValue: String) = viewModelScope.launch(Dispatchers.IO) {
        getBroadListUseCase(GetBroadListUseCase.Params(selectValue))
            .cachedIn(viewModelScope)
            .collect { response ->
                _broads.value = response
            }
    }

    fun setIsRefreshing(isRefreshing: Boolean) {
        Log.d("kkkk", isRefreshing.toString())
        _isRefreshing.value = isRefreshing
    }
}
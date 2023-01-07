package com.hardy.afreeca.ui.broaddetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.hardy.domain.model.Broad
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BroadDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val broad: Broad? = savedStateHandle.get<Broad>(BROAD_KEY)

    companion object {
        const val BROAD_KEY = "broad"
    }
}
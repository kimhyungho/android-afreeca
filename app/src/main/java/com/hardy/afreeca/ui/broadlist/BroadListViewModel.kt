package com.hardy.afreeca.ui.broadlist


import androidx.lifecycle.ViewModel
import com.hardy.domain.interactors.broad.GetBroadListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BroadListViewModel @Inject constructor(
    private val getBroadListUseCase: GetBroadListUseCase
) : ViewModel() {

}
package com.hardy.afreeca.ui.broadlist

import androidx.fragment.app.viewModels
import com.hardy.afreeca.R
import com.hardy.afreeca.base.BaseViewModelFragment
import com.hardy.afreeca.databinding.FragmentBroadListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BroadListFragment : BaseViewModelFragment<FragmentBroadListBinding, BroadListViewModel>(
    R.layout.fragment_broad_list
) {
    override val viewModel: BroadListViewModel by viewModels()
}
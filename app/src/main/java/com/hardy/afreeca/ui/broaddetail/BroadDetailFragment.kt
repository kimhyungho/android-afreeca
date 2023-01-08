package com.hardy.afreeca.ui.broaddetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.hardy.afreeca.R
import com.hardy.afreeca.base.BaseViewModelFragment
import com.hardy.afreeca.databinding.FragmentBroadDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BroadDetailFragment : BaseViewModelFragment<FragmentBroadDetailBinding, BroadDetailViewModel>(
    R.layout.fragment_broad_detail
) {
    override val viewModel: BroadDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewDataBinding) {
            toolbar.setNavigationOnClickListener {
                navController.popBackStack()
            }
        }
    }
}
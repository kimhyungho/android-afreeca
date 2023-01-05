package com.hardy.afreeca.ui.broadlist

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.hardy.afreeca.R
import com.hardy.afreeca.adapters.BroadListAdapter
import com.hardy.afreeca.base.BaseViewModelFragment
import com.hardy.afreeca.databinding.FragmentBroadListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BroadListFragment(
    private val selectValue: String?
) : BaseViewModelFragment<FragmentBroadListBinding, BroadListViewModel>(
    R.layout.fragment_broad_list
) {
    override val viewModel: BroadListViewModel by viewModels()

    private val broadListAdapter = BroadListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectValue?.let { viewModel.getBroadList(selectValue) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewDataBinding) {
            broadRecyclerView.adapter = broadListAdapter
        }

        with(viewModel) {
            lifecycleScope.launchWhenCreated {
                broads.collect { broads ->
                    broadListAdapter.submitData(lifecycle, broads)
                }
            }
        }
    }
}
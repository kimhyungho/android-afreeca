package com.hardy.afreeca.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayoutMediator
import com.hardy.afreeca.R
import com.hardy.afreeca.adapters.BroadListPagerAdapter
import com.hardy.afreeca.base.BaseViewModelFragment
import com.hardy.afreeca.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseViewModelFragment<FragmentMainBinding, MainViewModel>(
    R.layout.fragment_main
) {
    override val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val broadListPagerAdapter = BroadListPagerAdapter(childFragmentManager, lifecycle)

        with(viewDataBinding) {
            with(broadListViewPager) {
                adapter = broadListPagerAdapter
            }

            TabLayoutMediator(
                broadCategoryTabLayout,
                broadListViewPager,
                true,
                true,
                broadListPagerAdapter
            ).attach()
        }

        with(viewModel) {
            lifecycleScope.launchWhenCreated {
                broadCategories.collect {
                    broadListPagerAdapter.setItems(it)
                }
            }
        }
    }
}
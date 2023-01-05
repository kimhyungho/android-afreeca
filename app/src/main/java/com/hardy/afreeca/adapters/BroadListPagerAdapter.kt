package com.hardy.afreeca.adapters

import android.annotation.SuppressLint
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hardy.afreeca.ui.broadlist.BroadListFragment
import com.hardy.domain.model.BroadCategory

class BroadListPagerAdapter(
    private val fragmentManager: FragmentManager,
    private val lifecycle: Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle), TabLayoutMediator.TabConfigurationStrategy {
    private var broadCategories: List<BroadCategory> = listOf()

    override fun getItemCount(): Int {
        return broadCategories.size
    }

    override fun createFragment(position: Int): Fragment {
        return BroadListFragment()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(broadCategories: List<BroadCategory>) {
        this.broadCategories =
            if (broadCategories.size < 3) broadCategories else broadCategories.subList(0, 3)
        notifyDataSetChanged()
    }

    override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
        tab.text = broadCategories[position].cateName
    }
}
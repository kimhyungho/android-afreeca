package com.hardy.afreeca.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hardy.afreeca.R
import com.hardy.afreeca.databinding.LayoutLoadingStateBinding

class PagingStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<PagingStateAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_loading_state,
                parent,
                false
            ),
            retry
        )
    }

    class ViewHolder(
        private val binding: LayoutLoadingStateBinding,
        private val retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(loadState: LoadState) {
            with(binding) {
                when (loadState) {
                    is LoadState.Loading -> {
                        retryButton.visibility = View.INVISIBLE
                        loadingProgressBar.visibility = View.VISIBLE
                    }

                    is LoadState.Error -> {
                        retryButton.visibility = View.VISIBLE
                        loadingProgressBar.visibility = View.INVISIBLE
                    }

                    else -> {
                        retryButton.visibility = View.INVISIBLE
                        loadingProgressBar.visibility = View.INVISIBLE
                    }
                }

                retryButton.setOnClickListener {
                    retry.invoke()
                }
            }
        }
    }
}
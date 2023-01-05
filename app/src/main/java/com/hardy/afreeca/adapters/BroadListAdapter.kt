package com.hardy.afreeca.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hardy.afreeca.R
import com.hardy.afreeca.databinding.ItemBroadBinding
import com.hardy.domain.model.Broad

class BroadListAdapter :
    PagingDataAdapter<Broad, BroadListAdapter.ViewHolder>(
        BroadDiffCallback()
    ) {

    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_broad,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(item) }
    }

    class ViewHolder(
        private val binding: ItemBroadBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Broad) {
            with(binding) {
                uiModel = item
                executePendingBindings()
            }
        }
    }

    interface Listener {
        fun onClickItem(feedId: String)
    }
}

private class BroadDiffCallback : DiffUtil.ItemCallback<Broad>() {
    override fun areItemsTheSame(
        oldItem: Broad,
        newItem: Broad
    ): Boolean {
        return oldItem.broadNo == newItem.broadNo
    }

    override fun areContentsTheSame(
        oldItem: Broad,
        newItem: Broad
    ): Boolean {
        return oldItem == newItem
    }
}
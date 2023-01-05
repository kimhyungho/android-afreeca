package com.hardy.domain.repositories

import androidx.paging.PagingData
import com.hardy.domain.model.Broad
import kotlinx.coroutines.flow.Flow

interface BroadRepository {
    fun getBroadList(selectedValue: String?): Flow<PagingData<Broad>>
}
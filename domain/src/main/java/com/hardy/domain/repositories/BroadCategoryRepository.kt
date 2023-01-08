package com.hardy.domain.repositories

import com.hardy.domain.model.BroadCategory
import com.hardy.domain.model.Response
import kotlinx.coroutines.flow.Flow

interface BroadCategoryRepository {
    fun getBroadCategoryList(): Flow<Response<List<BroadCategory>>>
}
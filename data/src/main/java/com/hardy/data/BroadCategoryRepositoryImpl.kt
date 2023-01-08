package com.hardy.data

import com.hardy.data.mapper.BroadCategoryMapper
import com.hardy.data.remote.api.BroadCategoryService
import com.hardy.data.remote.api.BroadService
import com.hardy.domain.model.BroadCategory
import com.hardy.domain.model.Response
import com.hardy.domain.repositories.BroadCategoryRepository
import com.hardy.domain.repositories.BroadRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BroadCategoryRepositoryImpl @Inject constructor(
    private val broadCategoryService: BroadCategoryService
) : BroadCategoryRepository {
    override fun getBroadCategoryList(): Flow<Response<List<BroadCategory>>> = flow {
        try {
            val broadCategories =
                BroadCategoryMapper.mapToDomain(broadCategoryService.getBroadCategoryList())
            emit(Response.Success(broadCategories))
        } catch (e: Exception) {
            emit(Response.Failure(e))
        }
    }
}
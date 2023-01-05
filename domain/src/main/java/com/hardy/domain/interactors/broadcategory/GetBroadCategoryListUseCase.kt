package com.hardy.domain.interactors.broadcategory

import androidx.paging.PagingData
import com.hardy.domain.interactors.FlowUseCase
import com.hardy.domain.model.Broad
import com.hardy.domain.model.BroadCategory
import com.hardy.domain.model.Response
import com.hardy.domain.repositories.BroadCategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetBroadCategoryListUseCase @Inject constructor(
    private val repo: BroadCategoryRepository
) : FlowUseCase<Unit, List<BroadCategory>> {
    override fun invoke(params: Unit?): Flow<Response<List<BroadCategory>>> {
        return repo.getBroadCategoryList()
    }
}
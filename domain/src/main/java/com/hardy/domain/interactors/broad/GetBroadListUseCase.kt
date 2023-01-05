package com.hardy.domain.interactors.broad

import androidx.paging.PagingData
import com.hardy.domain.interactors.FlowUseCase
import com.hardy.domain.interactors.PagingUseCase
import com.hardy.domain.model.Broad
import com.hardy.domain.model.Response
import com.hardy.domain.repositories.BroadRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetBroadListUseCase @Inject constructor(
    private val repo: BroadRepository
) : PagingUseCase<GetBroadListUseCase.Params, Broad> {
    override fun invoke(params: Params?): Flow<PagingData<Broad>> {
        val (selectValue) = params ?: throw IllegalArgumentException("params can not be null")
        return repo.getBroadList(selectValue)
    }

    data class Params(
        val selectValue: String?
    )
}
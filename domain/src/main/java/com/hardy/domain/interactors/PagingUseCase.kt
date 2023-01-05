package com.hardy.domain.interactors

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface PagingUseCase<Params, T : Any> {
    operator fun invoke(params: Params? = null): Flow<PagingData<T>>
}
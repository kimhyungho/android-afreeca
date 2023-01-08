package com.hardy.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hardy.data.paging.GetBroadListPagingSource
import com.hardy.data.remote.api.BroadService
import com.hardy.domain.model.Broad
import com.hardy.domain.repositories.BroadRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BroadRepositoryImpl @Inject constructor(
    private val broadService: BroadService
) : BroadRepository {
    override fun getBroadList(selectedValue: String?): Flow<PagingData<Broad>> {
        return Pager(
            config = PagingConfig(
                pageSize = GetBroadListPagingSource.COUNT_PER_PAGE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                GetBroadListPagingSource(
                    broadService,
                    selectedValue
                )
            }
        ).flow
    }
}
package com.hardy.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hardy.data.mapper.BroadMapper
import com.hardy.data.remote.api.BroadService
import com.hardy.domain.model.Broad

class GetBroadListPagingSource(
    private val service: BroadService,
    private val selectedValue: String?
) : PagingSource<Int, Broad>(
) {

    override fun getRefreshKey(state: PagingState<Int, Broad>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Broad> {
        return try {
            val currentPage = params.key ?: 1
            val response = service.getBroadList(
                selectValue = selectedValue,
                pageNo = currentPage
            )
            val totalCount = response.totalCnt

            LoadResult.Page(
                data = response.broads?.map(BroadMapper::mapToDomain) ?: listOf(),
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (currentPage * 60 >= (totalCount ?: 0)) null else currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
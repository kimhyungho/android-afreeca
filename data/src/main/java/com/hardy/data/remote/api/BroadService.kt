package com.hardy.data.remote.api

import com.hardy.data.BuildConfig
import com.hardy.data.remote.model.response.GetBroadListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BroadService {
    @GET("/broad/list")
    suspend fun getBroadList(
        @Query("client_id")
        clientId: String = BuildConfig.CLIENT_ID,
        @Query("select_value")
        selectValue: String?,
        @Query("page_no")
        pageNo: Int,
    ): GetBroadListResponse
}
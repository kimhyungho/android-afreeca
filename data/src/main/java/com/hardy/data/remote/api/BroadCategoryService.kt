package com.hardy.data.remote.api

import com.hardy.data.BuildConfig
import com.hardy.data.remote.model.response.GetBroadCategoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BroadCategoryService {
    @GET("/broad/category/list")
    suspend fun getBroadCategoryList(
        @Query("client_id")
        clientId: String = BuildConfig.CLIENT_ID
    ): GetBroadCategoryResponse
}
package com.hardy.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class GetBroadCategoryResponse(
    @SerializedName("broad_category")
    val broadCategories: List<BroadCategoryResponse>? = null
) {
    data class BroadCategoryResponse(
        @SerializedName("cate_name")
        val cateName: String? = null,
        @SerializedName("cate_no")
        val cateNo: String? = null,
        @SerializedName("child")
        val child: List<ChildResponse>? = null
    ) {
        data class ChildResponse(
            @SerializedName("cate_name")
            val cateName: String? = null,
            @SerializedName("cate_no")
            val cateNo: String? = null
        )
    }
}
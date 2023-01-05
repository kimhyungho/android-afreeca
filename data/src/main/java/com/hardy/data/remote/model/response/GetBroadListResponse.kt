package com.hardy.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class GetBroadListResponse(
    @SerializedName("total_cnt")
    val totalCnt: Int? = null,
    @SerializedName("page_no")
    val pageNo: Int? = null,
    @SerializedName("broad")
    val broads: List<BroadResponse>? = null,
    @SerializedName("time")
    val time: Long? = null
) {
    data class BroadResponse(
        @SerializedName("broad_title")
        val broadTitle: String? = null,
        @SerializedName("visit_broad_type")
        val visitBroadType: String? = null,
        @SerializedName("is_password")
        val isPassword: String? = null,
        @SerializedName("broad_cate_no")
        val broadCateNo: String? = null,
        @SerializedName("broad_no")
        val broadNo: String? = null,
        @SerializedName("user_id")
        val userId: String? = null,
        @SerializedName("user_nick")
        val userNick: String? = null,
        @SerializedName("profile_img")
        val profileImg: String? = null,
        @SerializedName("broad_thumb")
        val broadThumb: String? = null,
        @SerializedName("broad_start")
        val broadStart: String? = null,
        @SerializedName("broad_grade")
        val broadGrad: String? = null,
        @SerializedName("broad_bps")
        val broadBps: String? = null,
        @SerializedName("broad_resolution")
        val broadResolution: String? = null,
        @SerializedName("total_view_cnt")
        val totalViewCnt: String? = null
    )
}
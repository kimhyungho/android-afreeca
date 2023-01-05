package com.hardy.data.mapper

import com.hardy.data.remote.model.response.GetBroadListResponse
import com.hardy.domain.model.Broad

object BroadMapper : Mapper<GetBroadListResponse.BroadResponse, Broad> {
    override fun mapToDomain(from: GetBroadListResponse.BroadResponse): Broad {
        return Broad(
            broadTitle = from.broadTitle,
            visitBroadType = from.visitBroadType,
            isPassword = from.isPassword,
            broadCateNo = from.broadCateNo,
            broadNo = from.broadNo,
            userId = from.userId,
            userNick = from.userNick,
            profileImg = from.profileImg,
            broadThumb = from.broadThumb,
            broadStart = from.broadStart,
            broadGrad = from.broadGrad,
            broadBps = from.broadBps,
            broadResolution = from.broadResolution,
            totalViewCnt = from.totalViewCnt
        )
    }
}
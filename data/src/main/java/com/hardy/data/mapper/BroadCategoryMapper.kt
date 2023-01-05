package com.hardy.data.mapper

import com.hardy.data.remote.model.response.GetBroadCategoryResponse
import com.hardy.domain.model.BroadCategory

object BroadCategoryMapper : Mapper<GetBroadCategoryResponse, List<BroadCategory>> {
    override fun mapToDomain(from: GetBroadCategoryResponse): List<BroadCategory> {
        return from.broadCategories?.map { category ->
            BroadCategory(
                cateName = category.cateName,
                cateNo = category.cateNo,
                child = category.child?.map { child ->
                    BroadCategory.Child(
                        cateName = child.cateName,
                        cateNo = child.cateNo
                    )
                }
            )
        } ?: listOf()
    }
}
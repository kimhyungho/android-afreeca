package com.hardy.domain.model

data class BroadCategory(
    val cateName: String?,
    val cateNo: String?,
    val child: List<Child>?
) {
    data class Child(
        val cateName: String?,
        val cateNo: String?
    )
}
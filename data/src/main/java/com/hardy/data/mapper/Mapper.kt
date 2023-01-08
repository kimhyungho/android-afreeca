package com.hardy.data.mapper

internal interface Mapper<Data, Domain> {
    fun mapToDomain(from: Data): Domain
}
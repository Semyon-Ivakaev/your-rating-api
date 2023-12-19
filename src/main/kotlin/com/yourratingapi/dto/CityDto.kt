package com.yourratingapi.dto

data class CityDto (
    val id: Int? = null,
    val name: String,
    val ruName: String,
    val shortName: String?,
    val priority: Int?,
    val countryId: Int,
)
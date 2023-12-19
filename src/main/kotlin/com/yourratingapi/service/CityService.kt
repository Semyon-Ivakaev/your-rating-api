package com.yourratingapi.service

import com.yourratingapi.dto.CityDto

interface CityService {

    fun getAllCities(): List<CityDto>

    fun search(prefix: String): List<CityDto>

    fun create(dto: CityDto): Int

    fun update(id: Int, dto: CityDto)

    fun delete(id: Int)
}
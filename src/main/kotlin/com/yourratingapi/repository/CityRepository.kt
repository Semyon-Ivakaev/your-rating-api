package com.yourratingapi.repository

import com.yourratingapi.entity.CityEntity
import org.springframework.data.repository.CrudRepository

interface CityRepository: CrudRepository<CityEntity, Int> {

    fun findByOrderByRuName(): List<CityEntity>

    fun findByRuNameStartsWithIgnoreCaseOrderByRuName(prefix: String): List<CityEntity>
}
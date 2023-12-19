package com.yourratingapi.service.impl

import com.yourratingapi.dto.CityDto
import com.yourratingapi.entity.CityEntity
import com.yourratingapi.repository.CityRepository
import com.yourratingapi.service.CityService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestPart

@Service
class CityServiceImpl(
    private val cityRepository: CityRepository
) : CityService {
    override fun getAllCities(): List<CityDto> {
        return cityRepository
            .findByOrderByRuName()
            .map { it.toDto() }
    }

    override fun search(prefix: String): List<CityDto> {
        return cityRepository.findByRuNameStartsWithIgnoreCaseOrderByRuName(prefix = prefix).map { it.toDto() }
    }

    override fun create(dto: CityDto): Int {
        return cityRepository.save(dto.toEntity()).id
    }

    override fun update(id: Int, dto: CityDto) {
        val existingCity = cityRepository.findByIdOrNull(id) ?: throw RuntimeException("City not found")
        existingCity.apply {
            name = dto.name
            ruName = dto.ruName
            shortName = dto.shortName ?: ruName
            priority = dto.priority ?: 0
            countryId = dto.countryId
        }
        cityRepository.save(existingCity)
    }

    override fun delete(id: Int) {
        val existingCity = cityRepository.findByIdOrNull(id) ?: throw RuntimeException("City not found")
        cityRepository.deleteById(existingCity.id)
    }

    private fun CityEntity.toDto(): CityDto =
        CityDto(
            id = this.id,
            name = this.name,
            priority = this.priority,
            ruName = this.ruName,
            shortName = this.shortName,
            countryId = this.countryId,
        )

    private fun CityDto.toEntity(): CityEntity =
        CityEntity(
            id = 0,
            name = this.name,
            ruName = this.ruName,
            priority = this.priority ?: 0,
            shortName = this.shortName ?: "",
            countryId = this.countryId,
        )
}
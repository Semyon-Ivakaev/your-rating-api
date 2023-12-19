package com.yourratingapi.controller

import com.yourratingapi.dto.CityDto
import com.yourratingapi.service.CityService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cities")
class CityController(
    private val cityService: CityService
) {

    @GetMapping
    fun getAll(): List<CityDto> = cityService.getAllCities()

    @GetMapping("/search")
    fun searchCity(@RequestParam("text") text: String): List<CityDto> = cityService.search(prefix = text)

    @PostMapping
    fun createCity(@RequestBody dto: CityDto): Int {
        return cityService.create(dto = dto)
    }

    @PutMapping("/{id}")
    fun updateCity(@PathVariable id: Int, @RequestBody dto: CityDto) {
        cityService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    fun deleteCity(@PathVariable id: Int) {
        cityService.delete(id = id)
    }
}
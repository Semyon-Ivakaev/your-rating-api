package com.yourratingapi.entity

import jakarta.persistence.*

@Entity
@Table(name = "cities")
class CityEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    var name: String = "",
    var priority: Int = 0,
    @Column(name = "ru_name")
    var ruName: String = "",
    @Column(name = "short_name")
    var shortName: String = "",
    @Column(name = "country_id")
    var countryId: Int = 0
)
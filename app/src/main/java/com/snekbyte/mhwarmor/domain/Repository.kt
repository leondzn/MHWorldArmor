package com.snekbyte.mhwarmor.domain

interface Repository {
    suspend fun getAllArmorSet(): List<ArmorSet>
    suspend fun findArmorSetByName(name: String): List<ArmorSet>
}
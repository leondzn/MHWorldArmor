package com.snekbyte.mhwarmor.data

import com.snekbyte.mhwarmor.domain.ArmorSet
import com.snekbyte.mhwarmor.domain.Repository


class RepositoryImpl(private val api: MHWorldApi) : Repository {

    override suspend fun getAllArmorSet(): List<ArmorSet> {
        val result = api.getAllArmorSet().body()

        return if (result != null) {
            return result.map { it.toModel() }
        } else {
            emptyList()
        }
    }

    override suspend fun findArmorSetByName(name: String): List<ArmorSet> {
        TODO("Not yet implemented")
    }
}

package com.snekbyte.mhwarmor.data

import com.snekbyte.mhwarmor.domain.ArmorSet
import com.snekbyte.mhwarmor.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class RepositoryImpl(private val api: MHWorldApi) : Repository {

    override suspend fun getAllArmorSet(): List<ArmorSet> = withContext(Dispatchers.IO) {
        val result = api.getAllArmorSet().body()

        return@withContext result?.map { it.toModel() } ?: emptyList()
    }

    override suspend fun findArmorSetByName(name: String): List<ArmorSet> {
        TODO("Not yet implemented")
    }
}

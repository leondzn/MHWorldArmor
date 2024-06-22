package com.snekbyte.mhwarmor.data

import retrofit2.Response
import retrofit2.http.GET

interface MHWorldApi {
    @GET("armor/sets")
    suspend fun getAllArmorSet(): Response<List<ArmorSetResponse>>
}
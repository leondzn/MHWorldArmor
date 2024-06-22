package com.snekbyte.mhwarmor.data

import java.util.Locale

data class ArmorSetResponse(
    val id: Int,
    val name: String,
    val pieces: List<ArmorResponse>,
)

package com.snekbyte.mhwarmor.domain

data class ArmorSet(
    val id: Int,
    val name: String,
    val pieces: List<Armor>,
)
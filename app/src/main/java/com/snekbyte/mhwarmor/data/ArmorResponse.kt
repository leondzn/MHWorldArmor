package com.snekbyte.mhwarmor.data

import java.util.Locale

data class ArmorResponse(
    val id: Int,
    val name: String,
    val type: String,
    val rarity: Int,
    val defense: Defense,
    val resistances: Resistances,
    val assets: Assets,
) {
    data class Defense(
        val base: Int,
        val max: Int,
    )

    data class Resistances(
        val fire: Int,
        val water: Int,
        val ice: Int,
        val thunder: Int,
        val dragon: Int,
    )

    data class Assets(
        val imageMale: String?
    )
}

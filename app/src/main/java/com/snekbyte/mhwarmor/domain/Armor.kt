package com.snekbyte.mhwarmor.domain

import java.util.Locale

data class Armor(
    val id: Int,
    val name: String,
    val type: String,
    val imageUrl: String,
    val baseDefense: Int,
    val maxDefense: Int,
    val fireResistance: Int,
    val waterResistance: Int,
    val iceResistance: Int,
    val thunderResistance: Int,
    val dragonResistance: Int,
) {
    enum class Type {
        HEAD, CHEST, GLOVES, WAIST, LEGS, UNKNOWN;

        companion object {
            fun fromString(name: String): Type {
                return when (name) {
                    "head" -> HEAD
                    "chest" -> CHEST
                    "gloves" -> GLOVES
                    "waist" -> WAIST
                    "legs" -> LEGS
                    else -> UNKNOWN
                }
            }
        }

        override fun toString(): String {
            return name.lowercase(Locale.ENGLISH)
        }
    }
}

package com.snekbyte.mhwarmor.data

import com.snekbyte.mhwarmor.domain.Armor
import com.snekbyte.mhwarmor.domain.ArmorSet

fun ArmorResponse.toModel(): Armor =
    Armor(
        id = this.id,
        name = this.name,
        type = Armor.Type.fromString(this.type),
        imageUrl = this.assets?.imageMale,
        baseDefense = this.defense.base,
        maxDefense = this.defense.max,
        fireResistance = this.resistances.fire,
        waterResistance = this.resistances.water,
        iceResistance = this.resistances.ice,
        thunderResistance = this.resistances.thunder,
        dragonResistance = this.resistances.dragon,
    )

fun ArmorSetResponse.toModel(): ArmorSet =
    ArmorSet(
        id = this.id,
        name = this.name,
        pieces = this.pieces.map { it.toModel() }
    )
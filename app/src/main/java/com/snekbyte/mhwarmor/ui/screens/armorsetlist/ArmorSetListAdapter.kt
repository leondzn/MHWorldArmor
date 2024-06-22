package com.snekbyte.mhwarmor.ui.screens.armorsetlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.snekbyte.mhwarmor.databinding.ItemArmorSetBinding
import com.snekbyte.mhwarmor.domain.Armor
import com.snekbyte.mhwarmor.domain.ArmorSet

class ArmorSetListAdapter : RecyclerView.Adapter<ArmorSetListAdapter.ViewHolder>() {
    private val items: ArrayList<ArmorSet> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<ArmorSet>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemArmorSetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(private val viewBinding: ItemArmorSetBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: ArmorSet) = with(viewBinding) {
            textName.text = item.name

            val head = item.pieces.find { it.type == Armor.Type.HEAD }
            val chest = item.pieces.find { it.type == Armor.Type.CHEST }
            val gloves = item.pieces.find { it.type == Armor.Type.GLOVES }
            val waist = item.pieces.find { it.type == Armor.Type.WAIST }
            val legs = item.pieces.find { it.type == Armor.Type.LEGS }

            val view = viewBinding.root
            Glide.with(view)
                .load(head?.imageUrl)
                .into(imageHead)
            Glide.with(view)
                .load(chest?.imageUrl)
                .into(imageHead)
            Glide.with(view)
                .load(gloves?.imageUrl)
                .into(imageHead)
            Glide.with(view)
                .load(waist?.imageUrl)
                .into(imageHead)
            Glide.with(view)
                .load(legs?.imageUrl)
                .into(imageHead)
        }
    }
}
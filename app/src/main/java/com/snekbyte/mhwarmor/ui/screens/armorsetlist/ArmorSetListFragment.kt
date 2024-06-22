package com.snekbyte.mhwarmor.ui.screens.armorsetlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.snekbyte.mhwarmor.databinding.FragmentArmorSetListBinding

class ArmorSetListFragment : Fragment() {
    private val adapter = ArmorSetListAdapter()

    private val viewBinding by lazy {
        FragmentArmorSetListBinding.inflate(LayoutInflater.from(requireContext()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = viewBinding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.listArmorSet.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ArmorSetListFragment.adapter
        }
    }
}
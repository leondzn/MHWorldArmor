package com.snekbyte.mhwarmor.ui.screens.armorsetlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snekbyte.mhwarmor.domain.ArmorSet
import com.snekbyte.mhwarmor.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ArmorSetListViewModel(
    private val repository: Repository
) : ViewModel() {
    private val _armorSetList = MutableStateFlow(emptyList<ArmorSet>())
    val armorSetList: StateFlow<List<ArmorSet>> = _armorSetList

    fun fetchAll() {
        viewModelScope.launch {
            val set = repository.getAllArmorSet()
            _armorSetList.value = set
        }
    }
}
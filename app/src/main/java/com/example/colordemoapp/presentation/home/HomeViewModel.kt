package com.example.colordemoapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.colordemoapp.common.ColorsResponse
import com.example.colordemoapp.domain.use_case.GetPalletteFromColorUseCase
import com.example.colordemoapp.domain.use_case.GetPalletteRandomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPalletteFromColorUseCase: GetPalletteFromColorUseCase,
    private val getPalletteRandomUseCase: GetPalletteRandomUseCase
) : ViewModel() {

    private val _state = mutableStateOf<HomeState>(HomeState())
    val state: State<HomeState> = _state

    fun getRandomColors() {
        getColors()
    }

    private fun getColors(hexColor: String) {
        getPalletteFromColorUseCase(hexColor).onEach { response ->
            when (response) {
                is ColorsResponse.Success -> {
                    _state.value = HomeState(colorsForPalette = response.data)
                }
                is ColorsResponse.Error -> {
                    _state.value = HomeState(error = response.message ?: "Unexpected error")
                }
                is ColorsResponse.Loading -> {
                    _state.value = HomeState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getColors() {
        getPalletteRandomUseCase().onEach { response ->
            when (response) {
                is ColorsResponse.Success -> {
                    _state.value = HomeState(colorsForPalette = response.data)
                }
                is ColorsResponse.Error -> {
                    _state.value = HomeState(error = response.message ?: "Unexpected error")
                }
                is ColorsResponse.Loading -> {
                    _state.value = HomeState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
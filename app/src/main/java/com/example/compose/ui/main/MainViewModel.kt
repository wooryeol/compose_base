package com.example.compose.ui.main

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.onFailure
import kotlin.onSuccess

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()

    @SuppressLint("SuspiciousIndentation")
    fun loadProfile() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val result = repository.getProfileData()

                result.onSuccess { data ->
                    _uiState.update { it.copy(profileData = data, isLoading = false) }
                }
                result.onFailure { error ->
                    _uiState.update { it.copy(errorMsg = error.message ?:"데이터를 가져오지 못했습니다.", isLoading = false) }
                }
        }
    }
}
package com.example.compose.ui.main

import com.example.compose.data.remote.ProfileResponse

// 화면의 모든 상태를 하나의 데이터 클래스로 정리 -> 관리 단순화
data class MainUiState (
    val profileData: ProfileResponse? = null,
    val isLoading: Boolean = false,
    val errorMsg: String? = null
)
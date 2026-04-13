package com.example.compose.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {viewModel.loadProfile() }) {
            Text("프로필 조회")
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            if (!state.errorMsg.isNullOrBlank()) {
                Text(text = state.errorMsg ?: "" )
            } else {state.profileData?.let {
                Text(text = "이름: ${it.name}" )
                Text(text = "나라: ${it.country}", style = MaterialTheme.typography.headlineSmall)
            }
            }
        }
    }
}
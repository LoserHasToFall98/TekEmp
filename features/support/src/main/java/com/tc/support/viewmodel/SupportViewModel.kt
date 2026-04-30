package com.tc.support.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.support.mock.MockGetRequestsUseCase
import com.tc.support.data.RequestResult
import com.tc.support.data.SupportIntents
import com.tc.support.data.SupportScreenUiState
import com.tc.support.data.reduce
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SupportViewModel : ViewModel() {

    private val _supportScreenUiState =
        MutableStateFlow<SupportScreenUiState>(SupportScreenUiState())

    val supportScreenUiState = _supportScreenUiState.asStateFlow()

    fun processIntent(intent : SupportIntents) {
        when (intent) {
            is SupportIntents.LoadRequests -> loadRequests()
        }
    }

    fun loadRequests() {
        viewModelScope.launch {
            updateState(RequestResult.Loading)

            try {
                val requests = MockGetRequestsUseCase().getRequests()
                updateState(RequestResult.Success(requests))
            } catch (e: Exception) {
                // 4. Emit Error State
                updateState(RequestResult.Error(e.message ?: "Unknown Error"))
            }
        }
    }

    private fun updateState(result: RequestResult) {
        _supportScreenUiState.update { currentState ->
            reduce(currentState, result)
        }
    }
}
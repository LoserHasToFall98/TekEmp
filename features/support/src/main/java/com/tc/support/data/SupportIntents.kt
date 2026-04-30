package com.tc.support.data

sealed class SupportIntents{
    data object LoadRequests : SupportIntents()
}

fun reduce(
    currentState: SupportScreenUiState,
    result: RequestResult
) : SupportScreenUiState {
    return when (result) {
        is RequestResult.Loading -> currentState.copy(isLoading = true)
        is RequestResult.Success -> currentState.copy(
            isLoading = false,
            requests = result.requests
        )
        is RequestResult.Error -> currentState.copy(
            isLoading = false,
            error = result.message
        )
    }
}
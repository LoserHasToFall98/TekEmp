package com.tc.profile

data class ProfileUiState(
    val profile: ProfileUiModel? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null
)

package com.tc.support.data

data class SupportScreenUiState(
    val isLoading : Boolean = false,
    var error : String = "",
    val requests : List<Request> = emptyList()
)
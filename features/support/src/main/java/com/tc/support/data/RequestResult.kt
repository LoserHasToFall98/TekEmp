package com.tc.support.data

sealed interface RequestResult {
    object Loading : RequestResult
    data class Success(val requests: List<Request>) : RequestResult
    data class Error(val message: String) : RequestResult
}
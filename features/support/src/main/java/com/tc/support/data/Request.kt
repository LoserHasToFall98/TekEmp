package com.tc.support.data

data class Request(
    val id: String,
    val type: RequestType,
    val date: String,
    val status: RequestStatus
)

enum class RequestType { GRIEVANCE, LEAVE, POLICY, IT_SUPPORT }
enum class RequestStatus { IN_REVIEW, APPROVED, CLOSED }

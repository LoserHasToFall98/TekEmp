package com.tc.support.mock

import com.tc.support.data.Request
import com.tc.support.data.RequestStatus
import com.tc.support.data.RequestType

class MockGetRequestsUseCase {
    fun getRequests() : List<Request> {
        return listOf(
            Request("402", RequestType.GRIEVANCE, "2026-04-29T10:23:45", RequestStatus.IN_REVIEW),
            Request("399", RequestType.LEAVE, "2026-04-22T14:15:02", RequestStatus.APPROVED),
            Request("385", RequestType.POLICY, "2026-04-18T09:05:30", RequestStatus.CLOSED),
            Request("382", RequestType.IT_SUPPORT, "2026-04-15T16:45:12", RequestStatus.APPROVED),
            Request("377", RequestType.LEAVE, "2026-04-12T11:20:00", RequestStatus.CLOSED),
            Request("370", RequestType.GRIEVANCE, "2026-04-10T08:30:55", RequestStatus.IN_REVIEW),
            Request("365", RequestType.IT_SUPPORT, "2026-04-05T13:12:10", RequestStatus.CLOSED),
            Request("360", RequestType.POLICY, "2026-04-01T17:55:22", RequestStatus.APPROVED),
            Request("355", RequestType.LEAVE, "2026-03-28T12:00:00", RequestStatus.CLOSED),
            Request("342", RequestType.GRIEVANCE, "2026-03-25T15:10:05", RequestStatus.APPROVED)
        ).sortedByDescending { it.date }
    }
}
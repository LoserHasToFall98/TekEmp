package com.tc.profile

data class ProfileUiModel(
val fullName: String,
val email: String,
val employeeId: String,
val department: String,
val position: String,
val joinDate: String,
val profilePictureUrl: String? = null,
val completionRate: Int = 98,
val tasksDoneThisWeek: Int = 12

)

package com.tc.profile

sealed class ProfileUiEvent {
    data object NavigateToEditProfile : ProfileUiEvent()
    data object NavigateToRequestLeave : ProfileUiEvent()
    data object NavigateToRaiseGrievance : ProfileUiEvent()
    data object NavigateToLogin : ProfileUiEvent()
    data class ShowError(val message: String) : ProfileUiEvent()
}
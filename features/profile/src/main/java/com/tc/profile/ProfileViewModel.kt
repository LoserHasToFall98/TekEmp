package com.tc.profile


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()
    private val _uiEvent = Channel<ProfileUiEvent>(Channel.BUFFERED)
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        loadProfile()
    }

    private fun loadProfile() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, isError = false) }

            try {

                val fakeProfile = ProfileUiModel(
                    fullName = "William Rozier",
                    email = "williamrozier@company.com",
                    employeeId = "EMP-02491",
                    department = "Engineering",
                    position = "Senior Android Developer",
                    joinDate = "March 2024"
                )


                _uiState.update {
                    it.copy(
                        isLoading = false,
                        profile = fakeProfile,
                        isError = false
                    )
                }

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isError = true,
                        errorMessage = "Failed to load profile"
                    )
                }
            }
        }
    }

    fun refreshProfile() {
        loadProfile()
    }

    fun onEditProfileClicked() {
        viewModelScope.launch {
            _uiEvent.send(ProfileUiEvent.NavigateToEditProfile)
        }
    }
}
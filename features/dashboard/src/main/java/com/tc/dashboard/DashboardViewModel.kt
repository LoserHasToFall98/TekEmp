package com.tc.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DashboardViewModel(private val dashboardRepository: DashboardRepository) : ViewModel() {
    private val _dashboards = MutableStateFlow<List<DashboardModel>>(value = emptyList())
    val dashboards = _dashboards.asStateFlow()

    fun getDashboard() {
        viewModelScope.launch {
            val response = dashboardRepository.getDashboard()
            _dashboards.update {
                response
            }
        }
    }
}
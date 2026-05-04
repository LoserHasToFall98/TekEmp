package com.tc.dashboard

class DashboardRepository() {

    private val dashboardList =
        listOf(
            DashboardModel(1, "Roel Cantu")
        )

    fun getDashboard(): List<DashboardModel> {
        return dashboardList
    }
}
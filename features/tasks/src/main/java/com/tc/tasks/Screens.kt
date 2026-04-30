package com.tc.tasks

sealed class Screens(screens: String){
data object CheckCircle: Screens("checkCircle")
    data object Message: Screens("message")
    data object Person: Screens("person")
    data object Home: Screens("Home")

}
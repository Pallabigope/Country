package com.example.mapcountryzip.view

sealed class Screen (val route: String){
    object FirstScreen: Screen("first_screen")
    object SecondScreen: Screen("second_screen")
    fun withArgs(vararg args:String):String{
        return buildString{
            append(route)
            args.forEach{arg->
                append("/$arg")
            }

        }
    }
}
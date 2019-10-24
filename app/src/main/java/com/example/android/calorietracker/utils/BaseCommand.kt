package com.example.android.calorietracker.utils

// The String parameter in each signature is only for logging purposes
sealed class BaseCommand {

    /**
     * When the user wants to search from the api
     */
    class ApiSearch(val errorString : String) : BaseCommand()

    /**
     * When the user inputs from a textfield / label
     */
    class Manual(val finishString : String): BaseCommand()
    /**
     * When the user inputs from favorites
     */
    class Favorites(val correctString: String): BaseCommand()
}
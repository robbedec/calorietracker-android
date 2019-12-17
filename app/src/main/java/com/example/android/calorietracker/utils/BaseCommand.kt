package com.example.android.calorietracker.utils

/**
 * Used to translate user intentions when adding entries.
 * In this application we differentiate adding from the API, manual input and from favorites.
 *
 * The String parameter in each signature is only for logging purposes.
 *
 * @author Robbe Decorte
 */
sealed class BaseCommand {

    class ApiSearch(val errorString : String) : BaseCommand()

    class Manual(val finishString : String): BaseCommand()
}
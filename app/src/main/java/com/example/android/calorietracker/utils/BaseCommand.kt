package com.example.android.calorietracker.utils

sealed class BaseCommand {
    // TODO: update to project needs

    /**
     * When the user inputs an error
     */
    class Error(val errorString : String) : BaseCommand()

    /**
     * When the user answers three questions correct
     */
    class Finish(val finishString : String): BaseCommand()
    /**
     * When the user inputs correct
     */
    class Correct(val correctString: String): BaseCommand()
}
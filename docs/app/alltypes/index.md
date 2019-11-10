

### All Types

|

##### [com.example.android.calorietracker.utils.BaseCommand](../com.example.android.calorietracker.utils/-base-command/index.md)

Used to translate user intentions when adding entries.
In this application we differentiate adding from the API, manual input and from favorites.


|

##### [com.example.android.calorietracker.data.room.CalorieDatabase](../com.example.android.calorietracker.data.room/-calorie-database/index.md)

Version needs to increment each time the database schema changes, this creates a versioning system to log schema changes.
To disable versioning use: exportSchema = false.


|

##### [com.example.android.calorietracker.data.network.CalorieTrackerApi](../com.example.android.calorietracker.data.network/-calorie-tracker-api/index.md)

[Retrofit](#) instance to make API calls.
This instance is a singleton


|

##### [com.example.android.calorietracker.data.network.CalorieTrackerApiService](../com.example.android.calorietracker.data.network/-calorie-tracker-api-service/index.md)


|

##### [com.example.android.calorietracker.data.models.enums.CalorieTrackerApiStatus](../com.example.android.calorietracker.data.models.enums/-calorie-tracker-api-status/index.md)

Representation of the API status.


|

##### [com.example.android.calorietracker.data.models.CategoryProperty](../com.example.android.calorietracker.data.models/-category-property/index.md)

Class that holds the different categories of [FoodProperty](../com.example.android.calorietracker.data.models/-food-property/index.md).


|

##### [com.example.android.calorietracker.ui.adapters.DataItem](../com.example.android.calorietracker.ui.adapters/-data-item/index.md)


|

##### [com.example.android.calorietracker.utils.DateConverter](../com.example.android.calorietracker.utils/-date-converter/index.md)

Convert java.util.date to Long so it can be stored in the database.


|

##### [com.example.android.calorietracker.data.models.EatingDay](../com.example.android.calorietracker.data.models/-eating-day/index.md)

Represents a single day that can be stored and retrieved from the Room database.


|

##### [com.example.android.calorietracker.data.room.EatingDayDao](../com.example.android.calorietracker.data.room/-eating-day-dao/index.md)

Collection of database queries.


|

##### [com.example.android.calorietracker.data.models.EatingDayWithEntries](../com.example.android.calorietracker.data.models/-eating-day-with-entries/index.md)

Database entity that embeds an [EatingDay](../com.example.android.calorietracker.data.models/-eating-day/index.md) with the entries from that day.


|

##### [com.example.android.calorietracker.data.models.FoodEntry](../com.example.android.calorietracker.data.models/-food-entry/index.md)

Represents a [FoodEntry](../com.example.android.calorietracker.data.models/-food-entry/index.md) that can be retrieved or pulled from the Room database.


|

##### [com.example.android.calorietracker.ui.adapters.FoodEntryAdapter](../com.example.android.calorietracker.ui.adapters/-food-entry-adapter/index.md)


|

##### [com.example.android.calorietracker.data.room.FoodEntryDao](../com.example.android.calorietracker.data.room/-food-entry-dao/index.md)


|

##### [com.example.android.calorietracker.ui.adapters.FoodEntryDiffCallback](../com.example.android.calorietracker.ui.adapters/-food-entry-diff-callback/index.md)


|

##### [com.example.android.calorietracker.ui.adapters.FoodEntryListener](../com.example.android.calorietracker.ui.adapters/-food-entry-listener/index.md)

Defining a click listener class, this method doesn't require you to store a full object reference
Use the id to make a database call when you need the object information


|

##### [com.example.android.calorietracker.data.models.FoodProperty](../com.example.android.calorietracker.data.models/-food-property/index.md)

Holds 1 category that can be retrieved from the API.


|

##### [com.example.android.calorietracker.ui.fragments.HomeFragment](../com.example.android.calorietracker.ui.fragments/-home-fragment/index.md)


|

##### [com.example.android.calorietracker.ui.viewModels.HomeViewModel](../com.example.android.calorietracker.ui.view-models/-home-view-model/index.md)


|

##### [com.example.android.calorietracker.utils.HomeViewModelFactory](../com.example.android.calorietracker.utils/-home-view-model-factory/index.md)

Create a [ViewModel](#) and check if it needs to use a database instance.
A [ViewModel](#) can only be created with a no-argument constructor, we use a ViewModel Factory initializing with arguments.


|

##### [com.example.android.calorietracker.ui.MainActivity](../com.example.android.calorietracker.ui/-main-activity/index.md)


|

##### [com.example.android.calorietracker.PusherApplication](../com.example.android.calorietracker/-pusher-application/index.md)

A base class that holds application wide logic.


|

##### [com.example.android.calorietracker.ui.SearchableActivity](../com.example.android.calorietracker.ui/-searchable-activity/index.md)


|

##### [com.example.android.calorietracker.ui.fragments.SearchFragment](../com.example.android.calorietracker.ui.fragments/-search-fragment/index.md)


|

##### [com.example.android.calorietracker.ui.adapters.SearchResultAdapter](../com.example.android.calorietracker.ui.adapters/-search-result-adapter/index.md)


|

##### [com.example.android.calorietracker.ui.viewModels.SearchViewModel](../com.example.android.calorietracker.ui.view-models/-search-view-model/index.md)

The [ViewModel](#) that is attached to [SearchFragment](#)


|

##### [com.example.android.calorietracker.utils.SingleLiveEvent](../com.example.android.calorietracker.utils/-single-live-event/index.md)

A lifecycle-aware observable that sends only new updates after subscription, used for events like
navigation and Snackbar messages.


| (extensions in package com.example.android.calorietracker.utils)

##### [android.widget.TextView](../com.example.android.calorietracker.utils/android.widget.-text-view/index.md)



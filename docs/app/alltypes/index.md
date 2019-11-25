

### All Types

| Name | Summary |
|---|---|
|

##### [com.example.android.calorietracker.data.network.dto.AbstractNutrient](../com.example.android.calorietracker.data.network.dto/-abstract-nutrient/index.md)


|

##### [com.example.android.calorietracker.utils.ApplicationViewModelFactory](../com.example.android.calorietracker.utils/-application-view-model-factory/index.md)

Create a [ViewModel](#) and check if it needs to use a database instance.
A [ViewModel](#) can only be created with a no-argument constructor, we use a ViewModel Factory initializing with arguments.


|

##### [com.example.android.calorietracker.utils.BaseCommand](../com.example.android.calorietracker.utils/-base-command/index.md)

Used to translate user intentions when adding entries.
In this application we differentiate adding from the API, manual input and from favorites.


|

##### [com.example.android.calorietracker.domain.CalorieBurningCalculator](../com.example.android.calorietracker.domain/-calorie-burning-calculator/index.md)

Estimates the amount of time needed (in minutes) to burn an amount of calories.
This class calculates running (9.5km/h), cycling (16km/h) and walking (4.8km/h).
More information about the formula or exercises can be found [here](https://www.hss.edu/conditions_burning-calories-with-exercise-calculating-estimated-energy-expenditure.asp).


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

##### [com.example.android.calorietracker.domain.enums.CalorieTrackerApiStatus](../com.example.android.calorietracker.domain.enums/-calorie-tracker-api-status/index.md)

Representation of the API status.


|

##### [com.example.android.calorietracker.data.network.dto.CategoryProperty](../com.example.android.calorietracker.data.network.dto/-category-property/index.md)

Class that holds the different categories of [FoodProperty](../com.example.android.calorietracker.data.network.dto/-food-property/index.md).


|

##### [com.example.android.calorietracker.data.room.entities.ClarifiedNutrient](../com.example.android.calorietracker.data.room.entities/-clarified-nutrient/index.md)


|

##### [com.example.android.calorietracker.ui.adapters.DataItem](../com.example.android.calorietracker.ui.adapters/-data-item/index.md)


|

##### [com.example.android.calorietracker.utils.DateConverter](../com.example.android.calorietracker.utils/-date-converter/index.md)

Convert java.util.date to Long so it can be stored in the database.


|

##### [com.example.android.calorietracker.data.room.entities.EatingDay](../com.example.android.calorietracker.data.room.entities/-eating-day/index.md)

Represents a single day that can be stored and retrieved from the Room database.


|

##### [com.example.android.calorietracker.data.room.EatingDayDao](../com.example.android.calorietracker.data.room/-eating-day-dao/index.md)

Collection of database queries.


|

##### [com.example.android.calorietracker.data.room.entities.EatingDayWithEntries](../com.example.android.calorietracker.data.room.entities/-eating-day-with-entries/index.md)

Database entity that embeds an [EatingDay](../com.example.android.calorietracker.data.room.entities/-eating-day/index.md) with the entries from that day.


|

##### [com.example.android.calorietracker.data.room.entities.FoodEntry](../com.example.android.calorietracker.data.room.entities/-food-entry/index.md)

Represents a [FoodEntry](../com.example.android.calorietracker.data.room.entities/-food-entry/index.md) that can be retrieved or pulled from the Room database.


|

##### [com.example.android.calorietracker.ui.adapters.FoodEntryAdapter](../com.example.android.calorietracker.ui.adapters/-food-entry-adapter/index.md)


|

##### [com.example.android.calorietracker.data.room.FoodEntryDao](../com.example.android.calorietracker.data.room/-food-entry-dao/index.md)


|

##### [com.example.android.calorietracker.ui.fragments.FoodEntryDetailFragment](../com.example.android.calorietracker.ui.fragments/-food-entry-detail-fragment/index.md)


|

##### [com.example.android.calorietracker.ui.viewModels.FoodEntryDetailViewModel](../com.example.android.calorietracker.ui.view-models/-food-entry-detail-view-model/index.md)


|

##### [com.example.android.calorietracker.utils.FoodEntryDetailViewModelFactory](../com.example.android.calorietracker.utils/-food-entry-detail-view-model-factory/index.md)


|

##### [com.example.android.calorietracker.ui.adapters.FoodEntryDiffCallback](../com.example.android.calorietracker.ui.adapters/-food-entry-diff-callback/index.md)


|

##### [com.example.android.calorietracker.ui.adapters.FoodEntryListener](../com.example.android.calorietracker.ui.adapters/-food-entry-listener/index.md)

Defining a click listener class, this method doesn't require you to store a full object reference
Use the id to make a database call when you need the object information


|

##### [com.example.android.calorietracker.data.room.entities.FoodEntryWithNutrients](../com.example.android.calorietracker.data.room.entities/-food-entry-with-nutrients/index.md)

Database entity helper that embeds an [FoodEntry](../com.example.android.calorietracker.data.room.entities/-food-entry/index.md) with the nutrients it contains.


|

##### [com.example.android.calorietracker.data.network.dto.FoodProperty](../com.example.android.calorietracker.data.network.dto/-food-property/index.md)

Holds 1 category that can be retrieved from the API.


|

##### [com.example.android.calorietracker.domain.FoodRepository](../com.example.android.calorietracker.domain/-food-repository/index.md)

Repository for fetching data from the database or API.


|

##### [com.example.android.calorietracker.ui.fragments.HomeFragment](../com.example.android.calorietracker.ui.fragments/-home-fragment/index.md)

Fragment shows the main page of the app.


|

##### [com.example.android.calorietracker.ui.viewModels.HomeViewModel](../com.example.android.calorietracker.ui.view-models/-home-view-model/index.md)


|

##### [com.example.android.calorietracker.ui.MainActivity](../com.example.android.calorietracker.ui/-main-activity/index.md)


|

##### [com.example.android.calorietracker.data.network.dto.NutrientInfo](../com.example.android.calorietracker.data.network.dto/-nutrient-info/index.md)


|

##### [com.example.android.calorietracker.ui.adapters.NutritionAdapter](../com.example.android.calorietracker.ui.adapters/-nutrition-adapter/index.md)


|

##### [com.example.android.calorietracker.data.network.dto.Photo](../com.example.android.calorietracker.data.network.dto/-photo/index.md)


|

##### [com.example.android.calorietracker.PusherApplication](../com.example.android.calorietracker/-pusher-application/index.md)

A base class that holds application wide logic.


|

##### [com.example.android.calorietracker.ui.SearchableActivity](../com.example.android.calorietracker.ui/-searchable-activity/index.md)


|

##### [com.example.android.calorietracker.ui.adapters.SearchEntryListener](../com.example.android.calorietracker.ui.adapters/-search-entry-listener/index.md)

Defining a click listener class, this method doesn't require you to store a full object reference
Use the id to make a database call when you need the object information


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



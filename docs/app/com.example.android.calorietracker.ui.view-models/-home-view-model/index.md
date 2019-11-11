[app](../../index.md) / [com.example.android.calorietracker.ui.viewModels](../index.md) / [HomeViewModel](./index.md)

# HomeViewModel

`class HomeViewModel : AndroidViewModel`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `HomeViewModel(database: `[`EatingDayDao`](../../com.example.android.calorietracker.data.room/-eating-day-dao/index.md)`, application: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [addFromState](add-from-state.md) | `val addFromState: `[`SingleLiveEvent`](../../com.example.android.calorietracker.utils/-single-live-event/index.md)`<`[`BaseCommand`](../../com.example.android.calorietracker.utils/-base-command/index.md)`>` |
| [currentCalories](current-calories.md) | The current amount of calories`var currentCalories: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [database](database.md) | `val database: `[`EatingDayDao`](../../com.example.android.calorietracker.data.room/-eating-day-dao/index.md) |
| [dialogList](dialog-list.md) | The options that are shown in de "add calories from" dialog`val dialogList: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [entries](entries.md) | List of entries of the current day that get auto updated`var entries: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FoodEntryEntity`](../../com.example.android.calorietracker.data.models/-food-entry/index.md)`>>` |
| [goal](goal.md) | The maximum amount of calories (the goal that the user wants to reach`val goal: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [navigateToFoodEntryOverview](navigate-to-food-entry-overview.md) | `val navigateToFoodEntryOverview: MutableLiveData<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>` |
| [percentage](percentage.md) | `val percentage: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [showSnackbarEvent](show-snackbar-event.md) | `val showSnackbarEvent: LiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |

### Functions

| Name | Summary |
|---|---|
| [addCalories](add-calories.md) | Method that gets called when a user wants to add calories to the counter`fun addCalories(checkedId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [doneShowingSnackbar](done-showing-snackbar.md) | `fun doneShowingSnackbar(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCleared](on-cleared.md) | ViewModal is destroyed and all current jobs will be cancelled`fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onFoodEntryClicked](on-food-entry-clicked.md) | `fun onFoodEntryClicked(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onFoodEntryNavigated](on-food-entry-navigated.md) | Reset to null to prevent bugs when configuration changes happen`fun onFoodEntryNavigated(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

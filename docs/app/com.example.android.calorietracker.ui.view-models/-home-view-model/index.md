[app](../../index.md) / [com.example.android.calorietracker.ui.viewModels](../index.md) / [HomeViewModel](./index.md)

# HomeViewModel

`class HomeViewModel : ViewModel`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `HomeViewModel(repository: `[`FoodRepository`](../../com.example.android.calorietracker.domain/-food-repository/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [addFromState](add-from-state.md) | `val addFromState: `[`SingleLiveEvent`](../../com.example.android.calorietracker.utils/-single-live-event/index.md)`<`[`BaseCommand`](../../com.example.android.calorietracker.utils/-base-command/index.md)`>` |
| [currentCalories](current-calories.md) | The current amount of calories`var currentCalories: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [dialogList](dialog-list.md) | The options that are shown in de "add calories from" dialog`val dialogList: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [entries](entries.md) | List of entries of the current day that get auto updated`var entries: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FoodEntry`](../../com.example.android.calorietracker.data.room.entities/-food-entry/index.md)`>>` |
| [goal](goal.md) | The maximum amount of calories (the goal that the user wants to reach`val goal: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [navigateToFoodEntryOverview](navigate-to-food-entry-overview.md) | `val navigateToFoodEntryOverview: LiveData<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>` |
| [percentage](percentage.md) | `val percentage: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [showErrorAlert](show-error-alert.md) | `val showErrorAlert: LiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [showSnackbarEvent](show-snackbar-event.md) | `val showSnackbarEvent: LiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |

### Functions

| Name | Summary |
|---|---|
| [addCaloriesSource](add-calories-source.md) | Method that gets called when a user wants to add calories to the counter`fun addCaloriesSource(checkedId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [addEntry](add-entry.md) | `fun addEntry(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [clearEntries](clear-entries.md) | Removes all the entries from this day`fun clearEntries(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [doneShowingSnackbar](done-showing-snackbar.md) | `fun doneShowingSnackbar(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCleared](on-cleared.md) | ViewModal is destroyed and all current jobs will be cancelled`fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onErrorAlertShown](on-error-alert-shown.md) | Reset property to prevent bugs when configuration changes happen.`fun onErrorAlertShown(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onFoodEntryClicked](on-food-entry-clicked.md) | Handles the click events from a [FoodEntry](../../com.example.android.calorietracker.data.room.entities/-food-entry/index.md).`fun onFoodEntryClicked(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, action: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onFoodEntryNavigated](on-food-entry-navigated.md) | Reset to null to prevent bugs when configuration changes happen.`fun onFoodEntryNavigated(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

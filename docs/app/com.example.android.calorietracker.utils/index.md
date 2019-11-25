[app](../index.md) / [com.example.android.calorietracker.utils](./index.md)

## Package com.example.android.calorietracker.utils

### Types

| Name | Summary |
|---|---|
| [ApplicationViewModelFactory](-application-view-model-factory/index.md) | Create a [ViewModel](#) and check if it needs to use a database instance. A [ViewModel](#) can only be created with a no-argument constructor, we use a ViewModel Factory initializing with arguments.`class ApplicationViewModelFactory : Factory` |
| [BaseCommand](-base-command/index.md) | Used to translate user intentions when adding entries. In this application we differentiate adding from the API, manual input and from favorites.`sealed class BaseCommand` |
| [DateConverter](-date-converter/index.md) | Convert java.util.date to Long so it can be stored in the database.`class DateConverter` |
| [FoodEntryDetailViewModelFactory](-food-entry-detail-view-model-factory/index.md) | `class FoodEntryDetailViewModelFactory : Factory` |
| [SingleLiveEvent](-single-live-event/index.md) | A lifecycle-aware observable that sends only new updates after subscription, used for events like navigation and Snackbar messages.`class SingleLiveEvent<T> : MutableLiveData<T>` |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [android.widget.TextView](android.widget.-text-view/index.md) |  |

### Functions

| Name | Summary |
|---|---|
| [asDatabaseEntity](as-database-entity.md) | `fun `[`FoodProperty`](../com.example.android.calorietracker.data.network.dto/-food-property/index.md)`.asDatabaseEntity(): `[`FoodEntry`](../com.example.android.calorietracker.data.room.entities/-food-entry/index.md) |
| [bindImage](bind-image.md) | `fun bindImage(imgView: `[`ImageView`](https://developer.android.com/reference/android/widget/ImageView.html)`, imgUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [bindRecyclerView](bind-recycler-view.md) | Bind a list to the adapter of a [RecyclerView](#).`fun <E> bindRecyclerView(recyclerView: RecyclerView, data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<E>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [bindStatus](bind-status.md) | Visualize the API status.`fun bindStatus(statusImageView: `[`ImageView`](https://developer.android.com/reference/android/widget/ImageView.html)`, status: `[`CalorieTrackerApiStatus`](../com.example.android.calorietracker.domain.enums/-calorie-tracker-api-status/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [formatAmount](format-amount.md) | `fun formatAmount(amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [formatGoal](format-goal.md) | `fun formatGoal(goal: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

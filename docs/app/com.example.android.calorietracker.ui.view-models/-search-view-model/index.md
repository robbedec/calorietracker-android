[app](../../index.md) / [com.example.android.calorietracker.ui.viewModels](../index.md) / [SearchViewModel](./index.md)

# SearchViewModel

`class SearchViewModel : ViewModel`

The [ViewModel](#) that is attached to [SearchFragment](#)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | The [ViewModel](#) that is attached to [SearchFragment](#)`SearchViewModel()` |

### Properties

| Name | Summary |
|---|---|
| [searchQuery](search-query.md) | The current value that the user wants to search for`var searchQuery: MutableLiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [searchResult](search-result.md) | `val searchResult: LiveData<`[`CategoryProperty`](../../com.example.android.calorietracker.data.models/-category-property/index.md)`>` |
| [status](status.md) | `val status: LiveData<`[`CalorieTrackerApiStatus`](../../com.example.android.calorietracker.data.models.enums/-calorie-tracker-api-status/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [onCleared](on-cleared.md) | Stop loading data when the [ViewModel](#) is destroyed`fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

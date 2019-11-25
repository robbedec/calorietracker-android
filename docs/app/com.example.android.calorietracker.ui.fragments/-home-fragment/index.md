[app](../../index.md) / [com.example.android.calorietracker.ui.fragments](../index.md) / [HomeFragment](./index.md)

# HomeFragment

`class HomeFragment : Fragment`

Fragment shows the main page of the app.

**Author**
Robbe Decorte

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Fragment shows the main page of the app.`HomeFragment()` |

### Functions

| Name | Summary |
|---|---|
| [onCreateOptionsMenu](on-create-options-menu.md) | Inflates the overflow menu`fun onCreateOptionsMenu(menu: `[`Menu`](https://developer.android.com/reference/android/view/Menu.html)`, inflater: `[`MenuInflater`](https://developer.android.com/reference/android/view/MenuInflater.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateView](on-create-view.md) | Inflates the layout with Data Binding and sets the lifecycle owner to the [HomeFragment](./index.md) to enable Data Binding and observe [LiveData](#). Sets up the [RecyclerView](#) with an adapter.`fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?` |
| [onOptionsItemSelected](on-options-item-selected.md) | Checks which item of the overflow menu was selected and triggers the action in [HomeViewModel](../../com.example.android.calorietracker.ui.view-models/-home-view-model/index.md).`fun onOptionsItemSelected(item: `[`MenuItem`](https://developer.android.com/reference/android/view/MenuItem.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

[app](../../index.md) / [com.example.android.calorietracker.ui.adapters](../index.md) / [FoodEntryAdapter](./index.md)

# FoodEntryAdapter

`class FoodEntryAdapter : ListAdapter<`[`DataItem`](../-data-item/index.md)`, ViewHolder>`

### Types

| Name | Summary |
|---|---|
| [FoodEntryHolder](-food-entry-holder/index.md) | Make private because it should not be called outside this class Contains all logic to manage views = separation of concerns`class FoodEntryHolder : ViewHolder` |
| [TextViewHolder](-text-view-holder/index.md) | `class TextViewHolder : ViewHolder` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FoodEntryAdapter(clickListener: `[`FoodEntryListener`](../-food-entry-listener/index.md)`)` |

### Functions

| Name | Summary |
|---|---|
| [addHeaderAndSubmitList](add-header-and-submit-list.md) | Add header to the front of the list`fun addHeaderAndSubmitList(list: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FoodEntryEntity`](../../com.example.android.calorietracker.data.models/-food-entry/index.md)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getItemViewType](get-item-view-type.md) | Return the type of the current item`fun getItemViewType(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onBindViewHolder](on-bind-view-holder.md) | Called when [RecyclerView](#) needs to show an item`fun onBindViewHolder(holder: ViewHolder, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | Called when RecyclerView needs a new [RecyclerView.ViewHolder](#)`fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): ViewHolder` |

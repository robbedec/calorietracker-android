[app](../../index.md) / [com.example.android.calorietracker.ui.adapters](../index.md) / [SearchResultAdapter](./index.md)

# SearchResultAdapter

`class SearchResultAdapter : ListAdapter<`[`FoodProperty`](../../com.example.android.calorietracker.data.models/-food-property/index.md)`, FoodPropertyViewHolder>`

### Types

| Name | Summary |
|---|---|
| [DiffCallback](-diff-callback/index.md) | `companion object DiffCallback : ItemCallback<`[`FoodProperty`](../../com.example.android.calorietracker.data.models/-food-property/index.md)`>` |
| [FoodPropertyViewHolder](-food-property-view-holder/index.md) | `class FoodPropertyViewHolder : ViewHolder` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SearchResultAdapter()` |

### Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: FoodPropertyViewHolder, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): FoodPropertyViewHolder` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [areContentsTheSame](are-contents-the-same.md) | `fun areContentsTheSame(oldItem: `[`FoodProperty`](../../com.example.android.calorietracker.data.models/-food-property/index.md)`, newItem: `[`FoodProperty`](../../com.example.android.calorietracker.data.models/-food-property/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [areItemsTheSame](are-items-the-same.md) | `fun areItemsTheSame(oldItem: `[`FoodProperty`](../../com.example.android.calorietracker.data.models/-food-property/index.md)`, newItem: `[`FoodProperty`](../../com.example.android.calorietracker.data.models/-food-property/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

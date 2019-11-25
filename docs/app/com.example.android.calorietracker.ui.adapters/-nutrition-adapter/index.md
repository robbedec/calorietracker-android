[app](../../index.md) / [com.example.android.calorietracker.ui.adapters](../index.md) / [NutritionAdapter](./index.md)

# NutritionAdapter

`class NutritionAdapter : ListAdapter<`[`ClarifiedNutrient`](../../com.example.android.calorietracker.data.room.entities/-clarified-nutrient/index.md)`, NutritionViewHolder>`

### Types

| Name | Summary |
|---|---|
| [DiffCallback](-diff-callback/index.md) | `companion object DiffCallback : ItemCallback<`[`ClarifiedNutrient`](../../com.example.android.calorietracker.data.room.entities/-clarified-nutrient/index.md)`>` |
| [NutritionViewHolder](-nutrition-view-holder/index.md) | `class NutritionViewHolder : ViewHolder` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NutritionAdapter()` |

### Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: NutritionViewHolder, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): NutritionViewHolder` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [areContentsTheSame](are-contents-the-same.md) | `fun areContentsTheSame(oldItem: `[`ClarifiedNutrient`](../../com.example.android.calorietracker.data.room.entities/-clarified-nutrient/index.md)`, newItem: `[`ClarifiedNutrient`](../../com.example.android.calorietracker.data.room.entities/-clarified-nutrient/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [areItemsTheSame](are-items-the-same.md) | `fun areItemsTheSame(oldItem: `[`ClarifiedNutrient`](../../com.example.android.calorietracker.data.room.entities/-clarified-nutrient/index.md)`, newItem: `[`ClarifiedNutrient`](../../com.example.android.calorietracker.data.room.entities/-clarified-nutrient/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

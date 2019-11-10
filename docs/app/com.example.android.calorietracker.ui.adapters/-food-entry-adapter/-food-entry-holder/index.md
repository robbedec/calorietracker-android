[app](../../../index.md) / [com.example.android.calorietracker.ui.adapters](../../index.md) / [FoodEntryAdapter](../index.md) / [FoodEntryHolder](./index.md)

# FoodEntryHolder

`class FoodEntryHolder : ViewHolder`

Make private because it should not be called outside this class
Contains all logic to manage views = separation of concerns

binding.root returns the constrained layout from the layout file to the ViewHolder

### Properties

| Name | Summary |
|---|---|
| [binding](binding.md) | `val binding: <ERROR CLASS>` |

### Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | `fun bind(item: `[`FoodEntry`](../../../com.example.android.calorietracker.data.models/-food-entry/index.md)`, clickListener: `[`FoodEntryListener`](../../-food-entry-listener/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [from](from.md) | `fun from(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`): FoodEntryHolder` |

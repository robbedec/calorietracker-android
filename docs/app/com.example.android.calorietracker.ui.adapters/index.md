[app](../index.md) / [com.example.android.calorietracker.ui.adapters](./index.md)

## Package com.example.android.calorietracker.ui.adapters

### Types

| Name | Summary |
|---|---|
| [DataItem](-data-item/index.md) | `sealed class DataItem` |
| [FoodEntryAdapter](-food-entry-adapter/index.md) | `class FoodEntryAdapter : ListAdapter<`[`DataItem`](-data-item/index.md)`, ViewHolder>` |
| [FoodEntryDiffCallback](-food-entry-diff-callback/index.md) | `class FoodEntryDiffCallback : ItemCallback<`[`DataItem`](-data-item/index.md)`>` |
| [FoodEntryListener](-food-entry-listener/index.md) | Defining a click listener class, this method doesn't require you to store a full object reference Use the id to make a database call when you need the object information`class FoodEntryListener` |
| [NutritionAdapter](-nutrition-adapter/index.md) | `class NutritionAdapter : ListAdapter<`[`ClarifiedNutrient`](../com.example.android.calorietracker.data.room.entities/-clarified-nutrient/index.md)`, NutritionViewHolder>` |
| [SearchEntryListener](-search-entry-listener/index.md) | Defining a click listener class, this method doesn't require you to store a full object reference Use the id to make a database call when you need the object information`class SearchEntryListener` |
| [SearchResultAdapter](-search-result-adapter/index.md) | `class SearchResultAdapter : ListAdapter<`[`FoodProperty`](../com.example.android.calorietracker.data.network.dto/-food-property/index.md)`, FoodPropertyViewHolder>` |

[app](../../index.md) / [com.example.android.calorietracker.ui.adapters](../index.md) / [FoodEntryDiffCallback](./index.md)

# FoodEntryDiffCallback

`class FoodEntryDiffCallback : ItemCallback<`[`DataItem`](../-data-item/index.md)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FoodEntryDiffCallback()` |

### Functions

| Name | Summary |
|---|---|
| [areContentsTheSame](are-contents-the-same.md) | Uses de generated equals method of a data class Compares all the fields of the oldItem with those of the newItem`fun areContentsTheSame(oldItem: `[`DataItem`](../-data-item/index.md)`, newItem: `[`DataItem`](../-data-item/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [areItemsTheSame](are-items-the-same.md) | Check when an entry is reloaded in de recyclerView With these methods the recyclerView won't update all the items but just those that contain a new listItem`fun areItemsTheSame(oldItem: `[`DataItem`](../-data-item/index.md)`, newItem: `[`DataItem`](../-data-item/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

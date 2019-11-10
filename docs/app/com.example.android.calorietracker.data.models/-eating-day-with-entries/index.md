[app](../../index.md) / [com.example.android.calorietracker.data.models](../index.md) / [EatingDayWithEntries](./index.md)

# EatingDayWithEntries

`data class EatingDayWithEntries`

Database entity that embeds an [EatingDay](../-eating-day/index.md) with the entries from that day.

### Constructors

| [&lt;init&gt;](-init-.md) | Creates an [EatingDayWithEntries](./index.md) with default properties or with the properties provided in the constructor.`EatingDayWithEntries(eatingDay: `[`EatingDay`](../-eating-day/index.md)`? = null, entries: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FoodEntry`](../-food-entry/index.md)`> = ArrayList())` |

### Properties

| [eatingDay](eating-day.md) | the [EatingDay](../-eating-day/index.md) object.`var eatingDay: `[`EatingDay`](../-eating-day/index.md)`?` |
| [entries](entries.md) | a [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) of [FoodEntry](../-food-entry/index.md) from the embedded [EatingDay](../-eating-day/index.md).`var entries: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FoodEntry`](../-food-entry/index.md)`>` |


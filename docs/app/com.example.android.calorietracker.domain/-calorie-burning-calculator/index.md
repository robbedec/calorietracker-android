[app](../../index.md) / [com.example.android.calorietracker.domain](../index.md) / [CalorieBurningCalculator](./index.md)

# CalorieBurningCalculator

`data class CalorieBurningCalculator`

Estimates the amount of time needed (in minutes) to burn an amount of calories.
This class calculates running (9.5km/h), cycling (16km/h) and walking (4.8km/h).
More information about the formula or exercises can be found [here](https://www.hss.edu/conditions_burning-calories-with-exercise-calculating-estimated-energy-expenditure.asp).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Estimates the amount of time needed (in minutes) to burn an amount of calories. This class calculates running (9.5km/h), cycling (16km/h) and walking (4.8km/h). More information about the formula or exercises can be found [here](https://www.hss.edu/conditions_burning-calories-with-exercise-calculating-estimated-energy-expenditure.asp).`CalorieBurningCalculator(weight: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 70.0, amountCal: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)` |

### Functions

| Name | Summary |
|---|---|
| [calculate](calculate.md) | Calculates how many minutes it takes to burn the amount of calories.`fun calculate(): `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |

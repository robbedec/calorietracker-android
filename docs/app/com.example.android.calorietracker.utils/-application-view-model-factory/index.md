[app](../../index.md) / [com.example.android.calorietracker.utils](../index.md) / [ApplicationViewModelFactory](./index.md)

# ApplicationViewModelFactory

`class ApplicationViewModelFactory : Factory`

Create a [ViewModel](#) and check if it needs to use a database instance.
A [ViewModel](#) can only be created with a no-argument constructor, we use a ViewModel Factory initializing with arguments.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Create a [ViewModel](#) and check if it needs to use a database instance. A [ViewModel](#) can only be created with a no-argument constructor, we use a ViewModel Factory initializing with arguments.`ApplicationViewModelFactory(foodRepository: `[`FoodRepository`](../../com.example.android.calorietracker.domain/-food-repository/index.md)`)` |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun <T : ViewModel?> create(modelClass: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>): T` |

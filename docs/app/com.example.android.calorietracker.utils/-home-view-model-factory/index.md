[app](../../index.md) / [com.example.android.calorietracker.utils](../index.md) / [HomeViewModelFactory](./index.md)

# HomeViewModelFactory

`class HomeViewModelFactory : Factory`

Create a [ViewModel](#) and check if it needs to use a database instance.
A [ViewModel](#) can only be created with a no-argument constructor, we use a ViewModel Factory initializing with arguments.

### Constructors

| [&lt;init&gt;](-init-.md) | Create a [ViewModel](#) and check if it needs to use a database instance. A [ViewModel](#) can only be created with a no-argument constructor, we use a ViewModel Factory initializing with arguments.`HomeViewModelFactory(dataSource: `[`EatingDayDao`](../../com.example.android.calorietracker.data.room/-eating-day-dao/index.md)`, application: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`)` |

### Functions

| [create](create.md) | `fun <T : ViewModel?> create(modelClass: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>): T` |


[app](../../index.md) / [com.example.android.calorietracker.data.room](../index.md) / [CalorieDatabase](./index.md)

# CalorieDatabase

`abstract class CalorieDatabase : RoomDatabase`

Version needs to increment each time the database schema changes, this creates a versioning system to log schema changes.
To disable versioning use: exportSchema = false.

Contains a static method that returns an instance for the provided context.

**Author**
Robbe Decorte

### Constructors

| [&lt;init&gt;](-init-.md) | Version needs to increment each time the database schema changes, this creates a versioning system to log schema changes. To disable versioning use: exportSchema = false.`CalorieDatabase()` |

### Properties

| [eatingDayDao](eating-day-dao.md) | `abstract val eatingDayDao: `[`EatingDayDao`](../-eating-day-dao/index.md) |
| [foodEntryDao](food-entry-dao.md) | `abstract val foodEntryDao: `[`FoodEntryDao`](../-food-entry-dao/index.md) |

### Companion Object Functions

| [getInstance](get-instance.md) | Claims exclusive access to the context and provides an instance (singleton) of the database. Initialize the singleton if the current value of the instance is null.`fun getInstance(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`CalorieDatabase`](./index.md) |


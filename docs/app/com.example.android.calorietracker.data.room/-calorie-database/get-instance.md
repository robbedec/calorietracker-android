[app](../../index.md) / [com.example.android.calorietracker.data.room](../index.md) / [CalorieDatabase](index.md) / [getInstance](./get-instance.md)

# getInstance

`fun getInstance(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`CalorieDatabase`](index.md)

Claims exclusive access to the context and provides an instance (singleton) of the database.
Initialize the singleton if the current value of the instance is null.

### Parameters

`context` - contains global information about the application.

**Return**
an instance of the database.


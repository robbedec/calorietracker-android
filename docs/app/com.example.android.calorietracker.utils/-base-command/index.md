[app](../../index.md) / [com.example.android.calorietracker.utils](../index.md) / [BaseCommand](./index.md)

# BaseCommand

`sealed class BaseCommand`

Used to translate user intentions when adding entries.
In this application we differentiate adding from the API, manual input and from favorites.

The String parameter in each signature is only for logging purposes.

**Author**
Robbe Decorte

### Types

| Name | Summary |
|---|---|
| [ApiSearch](-api-search/index.md) | `class ApiSearch : `[`BaseCommand`](./index.md) |
| [Favorites](-favorites/index.md) | `class Favorites : `[`BaseCommand`](./index.md) |
| [Manual](-manual/index.md) | `class Manual : `[`BaseCommand`](./index.md) |

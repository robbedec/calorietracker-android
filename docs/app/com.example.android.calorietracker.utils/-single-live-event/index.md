[app](../../index.md) / [com.example.android.calorietracker.utils](../index.md) / [SingleLiveEvent](./index.md)

# SingleLiveEvent

`class SingleLiveEvent<T> : MutableLiveData<T>`

A lifecycle-aware observable that sends only new updates after subscription, used for events like
navigation and Snackbar messages.

### Constructors

| [&lt;init&gt;](-init-.md) | A lifecycle-aware observable that sends only new updates after subscription, used for events like navigation and Snackbar messages.`SingleLiveEvent()` |

### Functions

| [call](call.md) | Used for cases where T is Void, to make calls cleaner.`fun call(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [observe](observe.md) | `fun observe(owner: LifecycleOwner, observer: Observer<in T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setValue](set-value.md) | `fun setValue(t: T?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |


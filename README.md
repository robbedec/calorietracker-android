# Calorie tracker for Android
## Getting started

These instruction will allow you to run a copy of the project on your local machine for development and testing

### Prerequisits

```
Android Studio
```

### Installing

Clone the repository

```
git clone git@github.com:HoGentTIN/native-apps-groep-c-robbedec.git
```

Open the project in Android Studio and build

## Running tests

Run the following commands in the terminal or run the designated gradle tasks in Android Studio.

To run unit tests:
```
./gradlew test
```

To run instrumented unit tests (i.e. ui tests):
```
./gradlew connectedAndroidTest
```

## Documentation

Generate documentation by executing the following command in the root of the project or run the
dokka gradle task in Android Studio.

```
./gradlew dokka
```

This will generate the docs/ folder in the root of the project. This folder contains
the dokka generated Markdown (in github-flavored-markdown).


## Built with

* [Gradle](https://gradle.org) - Dependency Management
* [Koin](https://insert-koin.io/) - Dependency Injection
* [Room](https://developer.android.com/topic/libraries/architecture/room) - Persistence library for onboard database
* [Timber](https://github.com/JakeWharton/timber) - Logging tool
* [Retrofit](https://github.com/square/retrofit) - Http client
* [Moshi](https://github.com/square/moshi) - JSON parser
* [Nutritionix](https://www.nutritionix.com/) - public API and food database

## Authors

* **Robbe Decorte**

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details




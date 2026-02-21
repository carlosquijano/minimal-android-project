# minimal-android-project

This repository explores how simple it can be to set up a valid,
working Android project with **Jetpack Compose + Material 3**. You will need:

* One `.kt` activity source file
* One `AndroidManifest.xml`
* One `app/build.gradle.kts` (no root build.gradle)
* One `settings.gradle.kts`

## Project structure

```
project
 ├── settings.gradle.kts
 └── app
     ├── build.gradle.kts
     └── src
         └── main
             ├── AndroidManifest.xml
             └── java
                 └── pl
                     └── czak
                         └── minimal
                             └── MainActivity.kt
```

## How to build

```
$ git clone https://github.com/carlosquijano/minimal-android-project.git
$ cd minimal-android-project
$ gradle installDebug
```

The app will be installed on all devices accessible to `adb`.

## Requirements

- **Gradle 9.1+** installed on your system
- **Android Gradle Plugin 9.0.1** (defined in `app/build.gradle.kts`)
- Java 17+ (`JAVA_HOME` configured)
- Android SDK with API 36 (`ANDROID_HOME` configured)

## What's inside

- Kotlin + Jetpack Compose + Material 3
- Edge-to-edge by default
- Minimal Gradle configuration (no wrapper, you bring your own Gradle)
- Single activity with "Hello world!"

## Notes

- No Gradle wrapper is included — the project expects you to have Gradle installed globally. This keeps the repository even smaller and lets you use your preferred Gradle version.
- AGP 9.0.1 works best with **Android Studio Otter 3 Feature Drop (2025.2.3) or newer**, but you can use any IDE that supports Gradle builds.

## Contact

Suggestions on how to minimize this further are welcome!

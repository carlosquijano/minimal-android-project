# minimal-android-project

This repository explores how simple it can be to set up a valid,
working Android project with **Kotlin + Jetpack Compose + Material 3**. 

You will need:

* One `.kt` activity source file
* One `AndroidManifest.xml`
* One `settings.gradle.kts`
* One `app/build.gradle.kts` (no root `build.gradle.kts`)
* One `versions.toml` gradle catalog file
* Two theme resource files (`res/values/themes.xml` and `res/values-night/themes.xml`)

## Project structure

```
project
 ├── versions.toml
 ├── settings.gradle.kts
 └── app
     ├── build.gradle.kts
     └── src
         └── main
             ├── AndroidManifest.xml
             ├── java
             │   └── io.github
             │       └── carlosquijano
             │           └── minimal
             │               ├── MainActivity.kt
             └── res
                 └── values
                     ├── themes.xml
                     └── themes.xml (in values-night/)
```

## AndroidManifest.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
    <application
        android:label="minimal-android-project"
        android:theme="@style/Theme.Minimal"
        android:icon="@android:drawable/sym_def_app_icon">
        <activity android:name="MainActivity" android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
```

## MainActivity.kt

```kotlin
class MainActivity : ComponentActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Text(
                    text = "Hello world!",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
    }
}
```

## Theme resource files

**`res/values/themes.xml`** (light theme):
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <style name="Theme.Minimal" parent="android:Theme.Material.Light.NoActionBar" />
</resources>
```

**`res/values-night/themes.xml`** (dark theme):
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <style name="Theme.Minimal" parent="android:Theme.Material.NoActionBar" />
</resources>
```

> These XML themes only remove the ActionBar. Colors are handled by Compose.

### How colors work:
- **Android 12+ (API 31+)**: App uses system dynamic colors (from wallpaper)
- **Android < 12**: App uses Material 3 default colors
- **Dark/Light mode**: Automatically handled by MaterialTheme
- XML themes only remove ActionBar — colors are controlled by Compose

## How to build

```
$ git clone https://github.com/carlosquijano/minimal-android-project.git
$ cd minimal-android-project
$ gradle installDebug
```

> The app will be installed on all devices accessible to `adb`.

## How to build and test with coverage

```
$ gradle testDebugUnitTest
$ gradle createDebugCoverageReport
$ open app/build/reports/coverage/androidTest/debug/connected/index.html
```

Why 100% coverage is possible
- The single test testGreeting() covers:
- Activity lifecycle (onCreate)
- Compose UI rendering
- MaterialTheme integration
- The entire codebase in one assertion

## Requirements

- **Gradle 9.1+** installed on your system
- **Android Gradle Plugin 9.0.1** (defined in `app/build.gradle.kts`)
- Java 17+ (`JAVA_HOME` configured)
- Android SDK with API 36 (`ANDROID_HOME` configured)

## What's inside

- Kotlin + Jetpack Compose + Material 3
- Minimal Gradle configuration (no wrapper, you bring your own Gradle)
- Dynamic colors on Android 12+ (Material You)
- Native Android themes (no AppCompat) with light/dark mode support
- No action bar (Edge-to-edge by default)
- Single activity with "Hello world!"


## What makes this minimal
- ✅ No Theme.kt - colors handled by MaterialTheme defaults
- ✅ Single test file achieving 100% coverage
- ✅ Native Android themes (no AppCompat)
- ✅ No Gradle wrapper - use your global Gradle
- ✅ Single activity, single test
- ✅ 100% JaCoCo test coverage with one test

## Notes

- No Gradle wrapper is included — the project expects you to have Gradle installed globally. This keeps the repository even smaller and lets you use your preferred Gradle version.
- Using native Android themes (`android:Theme.Material`) means no AppCompat dependency required.
- Colors are handled entirely by Compose — XML themes only control the ActionBar.
- Version catalog TOML file makes it easy to update dependencies.
- AGP 9.0.1 works best with **Android Studio Otter 3 Feature Drop (2025.2.3) or newer**, but you can use any IDE that supports Gradle builds.
- Repository is set up as a **GitHub template**. Use the "Use this template" button to create new projects with the same minimal structure and 100% test coverage already configured.

## Contact

Suggestions on how to minimize this further are welcome!

# minimal-android-project

This repository explores how simple it can be to set up a valid,
working Android project with **Jetpack Compose + Material 3**. You will need:

* One `.kt` activity source file
* One `AndroidManifest.xml`
* Two theme files (`res/values/themes.xml` and `res/values-night/themes.xml`)
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
             ├── java
             │   └── pl
             │       └── czak
             │           └── minimal
             │               └── MainActivity.kt
             └── res
                 └── values
                     ├── themes.xml
                     └── themes.xml (in values-night/)
```

## Theme files

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

These XML themes only remove the ActionBar. Colors are handled by Compose.

## AndroidManifest.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
    <application 
        android:label="minimal-android-project"
        android:theme="@style/Theme.Minimal">
        <activity 
            android:name="MainActivity" 
            android:exported="true">
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colorScheme = when {
                    Build.VERSION.SDK_INT >= 31 -> dynamicLightColorScheme(this)
                    else -> lightColorScheme()
                }
            ) {
                Box(
                    modifier = Modifier.fillMaxSize().systemBarsPadding(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Hello world!")
                }
            }
        }
    }
}
```

### How colors work:
- **Android 12+ (API 31+)**: App uses system dynamic colors (from wallpaper)
- **Android < 12**: App uses Material 3 default colors
- **Dark/Light mode**: Automatically handled by `dynamicLightColorScheme()` and `lightColorScheme()`
- XML themes only remove ActionBar — colors are controlled by Compose

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
- Dynamic colors on Android 12+ (Material You)
- Native Android themes (no AppCompat) with light/dark mode support
- No action bar
- Minimal Gradle configuration (no wrapper, you bring your own Gradle)
- Single activity with "Hello world!"

## Notes

- No Gradle wrapper is included — the project expects you to have Gradle installed globally. This keeps the repository even smaller and lets you use your preferred Gradle version.
- AGP 9.0.1 works best with **Android Studio Otter 3 Feature Drop (2025.2.3) or newer**, but you can use any IDE that supports Gradle builds.
- Using native Android themes (`android:Theme.Material`) means no AppCompat dependency required.
- Colors are handled entirely by Compose — XML themes only control the ActionBar.

## Contact

Suggestions on how to minimize this further are welcome!

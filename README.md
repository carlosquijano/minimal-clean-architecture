# minimal-android-project

This repository explores how simple it can be to set up a valid,
working Android project with **Kotlin + Jetpack Compose + Material 3**.

You will need:

* One `.kt` activity source file
* One `.kt` activity source test file
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
         ├── main
         │   ├── AndroidManifest.xml
         │   ├── java/io/github/carlosquijano/minimal
         │   │   └── MainActivity.kt
         │   └── res
         │       └── values
         │           ├── themes.xml
         │           └── themes.xml (in values-night/)
         └── test
             └── java/io/github/carlosquijano/minimal
                 └── MainActivityTest.kt
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
            val darkTheme = isSystemInDarkTheme()
            val supportsDynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
            val colorScheme = when {
                supportsDynamicColor && darkTheme -> dynamicDarkColorScheme(this)
                supportsDynamicColor && !darkTheme -> dynamicLightColorScheme(this)
                darkTheme -> darkColorScheme()
                else -> lightColorScheme()
            }

            MaterialTheme(colorScheme = colorScheme) {
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

**`res/values-night/themes.xml** (dark theme):
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

## Testing with Robolectric

This project uses **Robolectric** for fast, reliable unit tests without emulators:

- ✅ **4 tests** covering all theme combinations (light/dark, low/high API)
- ✅ **100% line and branch coverage**
- ✅ **No emulator needed** - runs in seconds on JVM

### MainActivityTest.kt

```kotlin
class MainActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    @Config(sdk = [Build.VERSION_CODES.M])
    fun testLowApi_lightTheme() {
        composeTestRule.onNodeWithText("Hello world!").assertExists()
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.M], qualifiers = "night")
    fun testLowApi_darkTheme() {
        composeTestRule.onNodeWithText("Hello world!").assertExists()
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.S])
    fun testHighApi_lightTheme() {
        composeTestRule.onNodeWithText("Hello world!").assertExists()
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.S], qualifiers = "night")
    fun testHighApi_darkTheme() {
        composeTestRule.onNodeWithText("Hello world!").assertExists()
    }
}
```

## How to build

```bash
git clone https://github.com/carlosquijano/minimal-android-project.git
cd minimal-android-project
gradle installDebug
```

> The app will be installed on all devices accessible to `adb`.

## How to run tests and coverage

```bash
# Run unit tests (fast, no emulator needed)
gradle testDebugUnitTest

# Generate coverage report (using Kover)
gradle koverHtmlReportDebug

# Open coverage report
open app/build/reports/kover/html/debug/index.html
```

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
- **Robolectric** for fast unit tests
- **Kover** for 100% coverage reporting

## What makes this minimal

- ✅ No Theme.kt - colors handled by MaterialTheme defaults
- ✅ **4 tests achieving 100% coverage** (all theme combinations)
- ✅ Native Android themes (no AppCompat)
- ✅ No Gradle wrapper - use your global Gradle
- ✅ Single activity
- ✅ **Robolectric instead of emulator tests** (faster, no AVD needed)
- ✅ **Kover** for simple coverage (no JaCoCo configuration)
- ✅ Version catalog for dependency management

## Notes

- No Gradle wrapper is included — the project expects you to have Gradle installed globally. This keeps the repository even smaller and lets you use your preferred Gradle version.
- Using native Android themes (`android:Theme.Material`) means no AppCompat dependency required.
- Colors are handled entirely by Compose — XML themes only control the ActionBar.
- Version catalog TOML file makes it easy to update dependencies.
- **Tests use Robolectric** - runs in seconds without emulators
- **Coverage uses Kover** - simpler than JaCoCo, works out of the box
- AGP 9.0.1 works best with **Android Studio Otter 3 Feature Drop (2025.2.3) or newer**, but you can use any IDE that supports Gradle builds.
- Repository is set up as a **GitHub template**. Use the "Use this template" button to create new projects with the same minimal structure and 100% test coverage already configured.

## Contact

Suggestions on how to minimize this further are welcome!

# minimal-clean-architecture

Clean Architecture template for Android with Compose, Koin and Room.

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
minimal-clean-architecture/
├── app/                          # Android app module
│   └── src/main/
├── core/
│   ├── domain/                   # Business logic (pure Kotlin)
│   │   └── src/main/java/        # Standard Android source code
│   └── data/                     # Data layer
│       └── src/main/java/        # Standard Android source code
├── gradle/
│   └── libs.versions.toml
├── .gitignore
└── settings.gradle.kts
```

## How to build

```bash
git clone https://github.com/carlosquijano/minimal-clean-architecture.git
cd minimal-clean-architecture
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

- Clean Architecture
- Kotlin + Jetpack Compose + Material 3
- Minimal Gradle configuration (no wrapper, you bring your own Gradle)
- Dynamic colors on Android 12+ (Material You)
- Native Android themes (no AppCompat) with light/dark mode support
- No action bar (Edge-to-edge by default)
- Single activity with "Hello world!"
- Koin and Room Database support
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

Suggestions on how to either minimize or enhance this further are welcome!

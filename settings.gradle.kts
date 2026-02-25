pluginManagement {
    repositories {
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("versions.toml"))
        }
    }
}

rootProject.name = "minimal-clean-architecture"
include(":core:domain", ":core:data")
include(":app")

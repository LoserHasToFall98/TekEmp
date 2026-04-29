pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TekEmp"
include(":app")
include(":features:dashboard")
include(":features:tasks")
include(":features:support")
include(":features:profile")
include(":features:forms")
include(":features:auth")
include(":app:nav")
include(":features:theme")

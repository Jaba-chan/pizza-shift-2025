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

rootProject.name = "pizza-shift-2025"
include(":app")
include(":feature")
include(":feature:auth")
include(":shared")
include(":shared:network")
include(":utils")
include(":components")
include(":components:theme")
include(":components:ui")
include(":feature:pizzaCatalog")
include(":shared:cart")
include(":shared:model")
include(":feature:pizzaDetail")
include(":shared:pizza")
include(":components:resource")
include(":feature:cart")
include(":shared:profile")
include(":shared:model:pizza")
include(":shared:model:user")
include(":shared:datastore")
include(":shared:datastore:otpToken")
include(":feature:payment")
include(":components:util")
include(":feature:profile")

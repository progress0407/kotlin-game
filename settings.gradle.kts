rootProject.name = "kotlin-game"

pluginManagement {
    val kotlinVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
            }
        }
    }
}

include("racing-car")
include("tetris")
include("gaspar-coding-breakout")
include("nadongbin-rhythm-game")
include("gui-global-utils")
include("baseball")

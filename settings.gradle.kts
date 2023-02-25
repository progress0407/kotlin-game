
rootProject.name = "kotlin-game"

include("racing-car")
include("tetris")

pluginManagement {
    val kotlinJvmVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinJvmVersion)
            }
        }
    }
}
include("gaspar-coding-breakout")
include("nadongbin-rhythm-game")
include("gui-global-utils")

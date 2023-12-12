import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    application
}

val projectGroup: String by project
val projectVersion: String by project

val kotestVersion: String by project
val javaVersion: String by project
val assertJCoreVersion: String by project

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

allprojects {
    group = projectGroup
    version = projectVersion

    repositories {
        mavenCentral()
    }
}

subprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        testImplementation(kotlin("test"))
        testImplementation("org.assertj:assertj-core:$assertJCoreVersion")

        listOf("runner-junit5", "assertions-core", "property").forEach { library ->
            testImplementation("io.kotest:kotest-$library:$kotestVersion")
        }
    }

    tasks.test {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = javaVersion
        }
    }
}

project("tetris") {

    task("hello").doLast {
        println("hello, ${project.name}")
    }
}

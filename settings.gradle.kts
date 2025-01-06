pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://repo.stellardrift.ca/repository/snapshots/")
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
        maven("https://repo.mizule.dev/releases")
        maven("https://repo.mizule.dev/snapshots")
        maven("https://repo.jpenilla.xyz/snapshots")
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

val name = "event-chain"

rootProject.name = "$name-parent"

sequenceOf(
        "common",
        "api",
        "bukkit",
        "bungee",
        "velocity",
        "jda",
        "kittehirc",
        "sponge",
        "pi4j",
        "kyori",
).forEach {
    val projectName = "$name-${it.replace("/", "-")}"
    include(projectName)
    project(":$projectName").projectDir = file(it)
}
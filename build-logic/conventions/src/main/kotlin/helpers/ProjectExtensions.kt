package helpers

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

const val projectPath = "com.kitos14.dashdot"
val jvmTargetVersion = JvmTarget.JVM_17
val javaVersion = JavaVersion.VERSION_17

fun Project.getLibs(): VersionCatalog =
    extensions.findByType(VersionCatalogsExtension::class.java)?.named("libs")
        ?: error("Version catalog 'libs' not found")

// path = :domain:game -> domain.game
val Project.modulePackageName
    get() = path
        .split(":")
        .filter { it.isNotBlank() }
        .joinToString(".") { it.lowercase() }


// path = :domain:game ->. domain:
val Project.modulePathWithoutName: String
    get() = path
        .split(":")
        .filter { it.isNotBlank() }
        .dropLast(1) // remove last (the module name)
        .joinToString(separator = ":", prefix = ":")
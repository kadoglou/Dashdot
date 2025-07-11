import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension

const val projectPath = "com.kitos14.dashdot"

fun Project.getLibs(): VersionCatalog =
    extensions.findByType(VersionCatalogsExtension::class.java)?.named("libs")
        ?: error("Version catalog 'libs' not found")

//// path = :domain:game -> DomainGame
//val Project.moduleName
//    get() = path
//        .split(":")
//        .filter { it.isNotBlank() }
//        .joinToString("") { it.capitalized() }

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
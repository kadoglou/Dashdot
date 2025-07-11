package data

import kotlinx.serialization.Serializable

@Serializable
enum class Day(val shortName: String) {
    Monday(shortName = "M"),
    Tuesday(shortName = "Tu"),
    Wednesday(shortName = "W"),
    Thursday(shortName = "Th"),
    Friday(shortName = "F"),
    Saturday(shortName = "Sa"),
    Sunday(shortName = "Su"),
}

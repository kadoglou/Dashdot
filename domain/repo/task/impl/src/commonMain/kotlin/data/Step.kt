package data

import kotlinx.serialization.Serializable

@Serializable
data class Step(
    val description: String,
    val done: Boolean = false
)

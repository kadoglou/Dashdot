package data

import kotlinx.datetime.LocalTime
import kotlinx.serialization.Serializable

@Serializable
data class TaskDto(
    val id: String? = null,
    val title: String,
    val startTime: LocalTime? = null,
    val endTime: LocalTime? = null,
    val days: HashSet<Day> = hashSetOf(),
    val note: String? = null,
    val steps: List<Step> = emptyList(),
    val done: Boolean = false,
    val parentTaskId: String? = null,
    val subTaskIds: List<String> = emptyList(),
)





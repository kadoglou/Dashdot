import com.kitos14.tools.Destination
import kotlinx.serialization.Serializable

// region External Destination

@Serializable
data object CreateTaskDestination : Destination()

// endregion


// region Internal Destinations

@Serializable
data object CreateTaskTitleDestination : Destination()

@Serializable
data object CreateTaskStartTimeDestination : Destination()

@Serializable
data object CreateTaskEndTimeDestination : Destination()

@Serializable
data object CreateTaskScheduleDestination : Destination()

// endregion
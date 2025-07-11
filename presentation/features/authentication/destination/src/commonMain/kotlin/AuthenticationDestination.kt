import com.kitos14.tools.Destination
import kotlinx.serialization.Serializable

// Graph entry point
@Serializable
data object AuthenticationDestination : Destination()

// Screen entry point
@Serializable
data object SignDestination : Destination()

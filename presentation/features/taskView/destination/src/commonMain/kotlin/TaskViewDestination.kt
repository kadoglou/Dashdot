import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.kitos14.tools.Destination
import kotlinx.serialization.Serializable

@Serializable
data class TaskViewDestination(val taskId: String) : Destination() {
    override fun getTopBar(navController: NavHostController?): @Composable (() -> Unit)? {
        return { Box(modifier = Modifier.background(AppTheme.colorScheme.background)) }
    }
}

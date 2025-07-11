import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController

val LocalRootNavController = compositionLocalOf<NavHostController> {
    error("No NavController provided! Make sure to use `CompositionLocalProvider`.")
}
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val GLOBAL_DURATION = 500
const val BACKGROUND_SCREEN_OFFSET_TRANSITION = 400

inline fun <reified T : Any> NavGraphBuilder.animatableComposable(
    duration: Int = GLOBAL_DURATION,
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable<T>(
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(durationMillis = duration)
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -BACKGROUND_SCREEN_OFFSET_TRANSITION },
                animationSpec = tween(durationMillis = duration)
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -BACKGROUND_SCREEN_OFFSET_TRANSITION },
                animationSpec = tween(durationMillis = duration)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(durationMillis = duration)
            )
        },
        content = content
    )
}

inline fun <reified T : Any> NavGraphBuilder.animatableVerticalComposable(
    duration: Int = GLOBAL_DURATION,
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable<T>(
        enterTransition = {
            slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(durationMillis = duration)
            )
        },
        exitTransition = {
            slideOutVertically(
                targetOffsetY = { -BACKGROUND_SCREEN_OFFSET_TRANSITION },
                animationSpec = tween(durationMillis = duration)
            )
        },
        popEnterTransition = {
            slideInVertically(
                initialOffsetY = { -BACKGROUND_SCREEN_OFFSET_TRANSITION },
                animationSpec = tween(durationMillis = duration)
            )
        },
        popExitTransition = {
            slideOutVertically(
                targetOffsetY = { it },
                animationSpec = tween(durationMillis = duration)
            )
        },
        content = content
    )
}
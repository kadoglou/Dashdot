import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf


private val LocalAppTypography = staticCompositionLocalOf { AppTypography() }

private val LocalAppDimen = staticCompositionLocalOf { AppDimen() }

private val LocalAppColor = staticCompositionLocalOf { AppColorResolved() }

@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalAppColor provides fullColorScheme.resolve(isDarkTheme), // 👈 resolve here
        LocalAppTypography provides typography(),
        LocalAppDimen provides dimens(),
        LocalIndication provides ripple(),
        content = content
    )
}

object AppTheme {

    val colorScheme: AppColorResolved
        @Composable get() = LocalAppColor.current

    val typography: AppTypography
        @Composable get() = LocalAppTypography.current

    val dimen: AppDimen
        @Composable get() = LocalAppDimen.current

}
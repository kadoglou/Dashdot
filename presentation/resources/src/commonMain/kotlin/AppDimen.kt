import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Stable
data class AppDimen(
    val topBarHeight: Dp = Dp.Unspecified,
    val createTaskInfoHeight: Dp = Dp.Unspecified,

    val paddingXXS: Dp = Dp.Unspecified,
    val paddingXS: Dp = Dp.Unspecified,
    val paddingS: Dp = Dp.Unspecified,
    val paddingM: Dp = Dp.Unspecified,
    val paddingL: Dp = Dp.Unspecified,
    val paddingXL: Dp = Dp.Unspecified,
    val paddingXXL: Dp = Dp.Unspecified,

    val buttonHeight: Dp = Dp.Unspecified, // Standard button height
    val inputFieldHeight: Dp = Dp.Unspecified, // Height for text fields
    val cardCornerRadius: Dp = Dp.Unspecified, // Rounded corners for cards
    val dialogCornerRadius: Dp = Dp.Unspecified, // Rounded corners for dialogs

    val elevationLow: Dp = Dp.Unspecified, // Low shadow elevation
    val elevationMedium: Dp = Dp.Unspecified, // Medium shadow elevation
    val elevationHigh: Dp = Dp.Unspecified // High shadow elevation
)

@Composable
internal fun dimens() = AppDimen(
    topBarHeight = 60.dp,
    createTaskInfoHeight = 200.dp,

    paddingXXS = 10.dp,
    paddingXS = 15.dp,
    paddingS = 20.dp,
    paddingM = 25.dp,
    paddingL = 30.dp,
    paddingXL = 45.dp,
    paddingXXL = 60.dp,

    buttonHeight = 48.dp,
    inputFieldHeight = 56.dp,
    cardCornerRadius = 12.dp,
    dialogCornerRadius = 16.dp,

    elevationLow = 2.dp,
    elevationMedium = 6.dp,
    elevationHigh = 12.dp
)
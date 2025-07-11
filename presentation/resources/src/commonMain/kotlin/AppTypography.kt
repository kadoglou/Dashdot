import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import dashdot.presentation.resources.generated.resources.InterDisplay_Black
import dashdot.presentation.resources.generated.resources.InterDisplay_BlackItalic
import dashdot.presentation.resources.generated.resources.InterDisplay_Bold
import dashdot.presentation.resources.generated.resources.InterDisplay_BoldItalic
import dashdot.presentation.resources.generated.resources.InterDisplay_ExtraBold
import dashdot.presentation.resources.generated.resources.InterDisplay_ExtraBoldItalic
import dashdot.presentation.resources.generated.resources.InterDisplay_ExtraLight
import dashdot.presentation.resources.generated.resources.InterDisplay_ExtraLightItalic
import dashdot.presentation.resources.generated.resources.InterDisplay_Italic
import dashdot.presentation.resources.generated.resources.InterDisplay_Light
import dashdot.presentation.resources.generated.resources.InterDisplay_LightItalic
import dashdot.presentation.resources.generated.resources.InterDisplay_Medium
import dashdot.presentation.resources.generated.resources.InterDisplay_MediumItalic
import dashdot.presentation.resources.generated.resources.InterDisplay_Regular
import dashdot.presentation.resources.generated.resources.InterDisplay_SemiBold
import dashdot.presentation.resources.generated.resources.InterDisplay_SemiBoldItalic
import dashdot.presentation.resources.generated.resources.InterDisplay_Thin
import dashdot.presentation.resources.generated.resources.InterDisplay_ThinItalic
import dashdot.presentation.resources.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Stable
data class AppTypography(
    val screenLargeTitle: TextStyle = TextStyle.Default,
    val screenMediumTitle: TextStyle = TextStyle.Default,

    val sectionHeader: TextStyle = TextStyle.Default,

    val noteParagraph: TextStyle = TextStyle.Default,

    val label: TextStyle = TextStyle.Default,

    val createTaskTitle: TextStyle = TextStyle.Default,
    val createTaskTitlePlaceholder: TextStyle = TextStyle.Default,
    val timePicker: TextStyle = TextStyle.Default,
    val buttonText: TextStyle = TextStyle.Default,
    val subtitleText: TextStyle = TextStyle.Default,
    val taskTitleList: TextStyle = TextStyle.Default,
    val subListTitle: TextStyle = TextStyle.Default,

    val logoText: TextStyle = TextStyle.Default,
    val bottomNavigationTitleUnselected: TextStyle = TextStyle.Default,
    val bottomNavigationTitleSelected: TextStyle = TextStyle.Default,
    val searchText: TextStyle = TextStyle.Default,
    val actionText: TextStyle = TextStyle.Default,
    val surfaceBold: TextStyle = TextStyle.Default,
    val surfaceMedium: TextStyle = TextStyle.Default,
    val surfaceLight: TextStyle = TextStyle.Default,
    val brandText: TextStyle = TextStyle.Default,
    val displayLarge: TextStyle = TextStyle.Default,
    val displayMedium: TextStyle = TextStyle.Default,
    val displaySmall: TextStyle = TextStyle.Default,
    val headlineLarge: TextStyle = TextStyle.Default,
    val headlineMedium: TextStyle = TextStyle.Default,
    val headlineSmall: TextStyle = TextStyle.Default,
    val titleLarge: TextStyle = TextStyle.Default,
    val titleMedium: TextStyle = TextStyle.Default,
    val titleSmall: TextStyle = TextStyle.Default,
    val bodyLarge: TextStyle = TextStyle.Default,
    val bodyMedium: TextStyle = TextStyle.Default,
    val bodySmall: TextStyle = TextStyle.Default,
    val labelLarge: TextStyle = TextStyle.Default,
    val labelMedium: TextStyle = TextStyle.Default,
    val labelSmall: TextStyle = TextStyle.Default
)

@Composable
internal fun typography() = AppTypography(

    screenLargeTitle = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.ExtraLight,
        fontSize = 46.sp,
        letterSpacing = 3.sp,
    ),

    screenMediumTitle = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.ExtraLight,
        fontSize = 38.sp,
        letterSpacing = 3.sp,
    ),

    sectionHeader = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        letterSpacing = 1.sp,
    ),

    noteParagraph = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Light,
        fontSize = 18.sp,
        letterSpacing = 1.sp,
        lineHeight = 1.4.em
    ),

    label = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Light,
        fontSize = 18.sp,
    ),

    createTaskTitle = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Light,
        fontSize = 32.sp,
    ),

    createTaskTitlePlaceholder = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Light,
        fontSize = 32.sp,
    ),

    timePicker = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Light,
        fontSize = 24.sp,
    ),

    buttonText = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),

    subtitleText = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
    ),

    taskTitleList = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.ExtraLight,
        fontSize = 28.sp,
        letterSpacing = 3.sp,
    ),

    subListTitle = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        letterSpacing = 1.sp,
    ),

    logoText = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
    ),

    bottomNavigationTitleUnselected = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
    ),

    bottomNavigationTitleSelected = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
    ),

    searchText = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    ),

    actionText = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    ),

    surfaceBold = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
    ),

    surfaceMedium = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
    ),

    surfaceLight = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Light,
        fontSize = 20.sp,
    ),

    brandText = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
    ),
    displayLarge = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Black,
        fontSize = 57.sp
    ),
    displayMedium = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 45.sp
    ),
    displaySmall = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp
    ),
    titleLarge = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
    titleSmall = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodySmall = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    labelMedium = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    labelSmall = TextStyle(
        fontFamily = InterDisplay(),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)

@Composable
private fun InterDisplay() = FontFamily(
    Font(Res.font.InterDisplay_Black, FontWeight.Black),
    Font(Res.font.InterDisplay_BlackItalic, FontWeight.Black, style = FontStyle.Italic),
    Font(Res.font.InterDisplay_Bold, FontWeight.Bold),
    Font(Res.font.InterDisplay_BoldItalic, FontWeight.Bold, style = FontStyle.Italic),
    Font(Res.font.InterDisplay_ExtraBold, FontWeight.ExtraBold),
    Font(Res.font.InterDisplay_ExtraBoldItalic, FontWeight.ExtraBold, style = FontStyle.Italic),
    Font(Res.font.InterDisplay_ExtraLight, FontWeight.ExtraLight),
    Font(Res.font.InterDisplay_ExtraLightItalic, FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(Res.font.InterDisplay_Italic, FontWeight.Normal, style = FontStyle.Italic),
    Font(Res.font.InterDisplay_Light, FontWeight.Light),
    Font(Res.font.InterDisplay_LightItalic, FontWeight.Light, style = FontStyle.Italic),
    Font(Res.font.InterDisplay_Medium, FontWeight.Medium),
    Font(Res.font.InterDisplay_MediumItalic, FontWeight.Medium, style = FontStyle.Italic),
    Font(Res.font.InterDisplay_Regular, FontWeight.Normal),
    Font(Res.font.InterDisplay_SemiBold, FontWeight.SemiBold),
    Font(Res.font.InterDisplay_SemiBoldItalic, FontWeight.SemiBold, style = FontStyle.Italic),
    Font(Res.font.InterDisplay_Thin, FontWeight.Thin),
    Font(Res.font.InterDisplay_ThinItalic, FontWeight.Thin, style = FontStyle.Italic)
)

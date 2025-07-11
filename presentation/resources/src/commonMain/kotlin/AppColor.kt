import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// region AppColor structure definition

internal fun AppColor.resolve(isDarkTheme: Boolean): AppColorResolved {
    fun pick(pair: Pair<Color, Color>) = if (isDarkTheme) pair.second else pair.first

    return AppColorResolved(
        // ========== PRIMARY COLORS ==========
        primary = pick(primary),
        onPrimary = pick(onPrimary),
        primaryContainer = pick(primaryContainer),
        onPrimaryContainer = pick(onPrimaryContainer),

        // ========== SECONDARY COLORS ==========
        secondary = pick(secondary),
        onSecondary = pick(onSecondary),
        secondaryContainer = pick(secondaryContainer),
        onSecondaryContainer = pick(onSecondaryContainer),

        // ========== TERTIARY COLORS ==========
        stableBlack = pick(stableBlack),
        stableWhite = pick(stableWhite),
        tertiaryContainer = pick(tertiaryContainer),
        stableGray = pick(stableGray),
        stableGrayTone2 = pick(stableGrayTone2),

        // ========== BACKGROUND & SURFACE COLORS ==========
        background = pick(background),
        onBackground = pick(onBackground),
        surface = pick(surface),
        onSurface = pick(onSurface),
        surfaceVariant = pick(surfaceVariant),
        onSurfaceVariant = pick(onSurfaceVariant),
        surfaceMuted = pick(surfaceMuted),
        onSurfaceDisabled = pick(onSurfaceDisabled),
        onBackgroundPlaceholder = pick(onBackgroundPlaceholder),
        onBackgroundText = pick(onBackgroundText),
        onBackgroundSecondary = pick(onBackgroundSecondary),
        secondaryOnBackground = pick(secondaryOnBackground),

        // ========== ERROR COLORS ==========
        error = pick(error),
        onError = pick(onError),
        errorContainer = pick(errorContainer),
        onErrorContainer = pick(onErrorContainer),

        // ========== OUTLINE & SEPARATORS ==========
        outline = pick(outline),
        outlineVariant = pick(outlineVariant),
        inverseSurface = pick(inverseSurface),
        inverseOnSurface = pick(inverseOnSurface),
        inversePrimary = pick(inversePrimary),

        // ========== SHADOW & OVERLAYS ==========
        shadow = pick(shadow),
        scrim = pick(scrim),

        // ========== CUSTOM COLORS ==========
        separator = pick(separator),
        switchBorder = pick(switchBorder),
        success = pick(success)
    )
}

@Stable
data class AppColorResolved(
    // ========== PRIMARY COLORS ==========

    /** The main brand color used most frequently in the UI */
    val primary: Color = Color.Unspecified,

    /** The color used for text/icons that appear on the primary color */
    val onPrimary: Color = Color.Unspecified,

    /** A lighter variation of the primary color, used for backgrounds */
    val primaryContainer: Color = Color.Unspecified,

    /** The color used for text/icons inside the primary container */
    val onPrimaryContainer: Color = Color.Unspecified,

    // ========== SECONDARY COLORS ==========

    /** A secondary color, used for less prominent UI elements */
    val secondary: Color = Color.Unspecified,

    /** The color used for text/icons that appear on the secondary color */
    val onSecondary: Color = Color.Unspecified,

    /** A lighter variation of the secondary color, used for backgrounds */
    val secondaryContainer: Color = Color.Unspecified,

    /** The color used for text/icons inside the secondary container */
    val onSecondaryContainer: Color = Color.Unspecified,

    // ========== TERTIARY COLORS ==========

    val stableBlack: Color = Color.Unspecified,

    /** The color used for text/icons that appear on the tertiary color */
    val stableWhite: Color = Color.Unspecified,

    /** A lighter variation of the tertiary color, used for backgrounds */
    val tertiaryContainer: Color = Color.Unspecified,

    /** The color used for text/icons inside the tertiary container */
    val stableGray: Color = Color.Unspecified,

    val stableGrayTone2: Color = Color.Unspecified,

    // ========== BACKGROUND & SURFACE COLORS ==========

    /** The primary background color of the UI */
    val background: Color = Color.Unspecified,

    /** The color used for text/icons on top of the background */
    val onBackground: Color = Color.Unspecified,

    /** A surface color, used for UI elements like cards, sheets, etc. */
    val surface: Color = Color.Unspecified,

    /** The color used for text/icons on top of the surface */
    val onSurface: Color = Color.Unspecified,

    /** A variation of the surface color, used for distinguishing UI layers */
    val surfaceVariant: Color = Color.Unspecified,

    /** The color used for text/icons on top of the surface variant */
    val onSurfaceVariant: Color = Color.Unspecified,

    /** A muted version of the surface, used for lower elevation or disabled surfaces */
    val surfaceMuted: Color = Color.Unspecified,

    /** For disabled texts on surface */
    val onSurfaceDisabled: Color = Color.Unspecified,

    /** Placeholder text on background */
    val onBackgroundPlaceholder: Color = Color.Unspecified,

    /** Less prominent content text */
    val onBackgroundText: Color = Color.Unspecified,

    /** Labels or secondary text */
    val onBackgroundSecondary: Color = Color.Unspecified,

    /** For less dominant secondary UI elements */
    val secondaryOnBackground: Color = Color.Unspecified,

    // ========== ERROR COLORS ==========

    /** The main error color, used for warnings and errors */
    val error: Color = Color.Unspecified,

    /** The color used for text/icons that appear on the error color */
    val onError: Color = Color.Unspecified,

    /** A lighter variation of the error color, used for backgrounds */
    val errorContainer: Color = Color.Unspecified,

    /** The color used for text/icons inside the error container */
    val onErrorContainer: Color = Color.Unspecified,

    // ========== OUTLINE & SEPARATORS ==========

    /** Color used for borders, dividers, and outlines */
    val outline: Color = Color.Unspecified,

    /** A softer/lighter variation of the outline color */
    val outlineVariant: Color = Color.Unspecified,

    /** Used for inverted surfaces in dark mode */
    val inverseSurface: Color = Color.Unspecified,

    /** The color used for text/icons on top of the inverse surface */
    val inverseOnSurface: Color = Color.Unspecified,

    /** A variation of the primary color for inverse contrast */
    val inversePrimary: Color = Color.Unspecified,

    // ========== SHADOW & OVERLAYS ==========

    /** Used for shadow effects, primarily in elevated components */
    val shadow: Color = Color.Unspecified,

    /** A semi-transparent overlay color (used in modals, drawers, etc.) */
    val scrim: Color = Color.Unspecified,

    // ========== CUSTOM COLORS ==========

    /** Custom separator color, used for dividers */
    val separator: Color = Color.Unspecified,

    /** Border color used for switches or toggles */
    val switchBorder: Color = Color.Unspecified,

    /** Success state color (e.g. confirmation messages) */
    val success: Color = Color.Unspecified
)

@Stable
internal data class AppColor(
    val primary: Pair<Color, Color>,
    val onPrimary: Pair<Color, Color> = unspecified(),
    val primaryContainer: Pair<Color, Color> = unspecified(),
    val onPrimaryContainer: Pair<Color, Color> = unspecified(),
    val secondary: Pair<Color, Color> = unspecified(),
    val onSecondary: Pair<Color, Color> = unspecified(),
    val secondaryContainer: Pair<Color, Color> = unspecified(),
    val onSecondaryContainer: Pair<Color, Color> = unspecified(),
    val stableBlack: Pair<Color, Color> = unspecified(),
    val stableWhite: Pair<Color, Color> = unspecified(),
    val tertiaryContainer: Pair<Color, Color> = unspecified(),
    val stableGray: Pair<Color, Color> = unspecified(),
    val stableGrayTone2: Pair<Color, Color> = unspecified(),
    val background: Pair<Color, Color>,
    val onBackground: Pair<Color, Color> = unspecified(),
    val surface: Pair<Color, Color>,
    val onSurface: Pair<Color, Color> = unspecified(),
    val surfaceVariant: Pair<Color, Color>,
    val onSurfaceVariant: Pair<Color, Color> = unspecified(),
    val surfaceMuted: Pair<Color, Color> = unspecified(),
    val onSurfaceDisabled: Pair<Color, Color> = unspecified(),
    val onBackgroundPlaceholder: Pair<Color, Color> = unspecified(),
    val onBackgroundText: Pair<Color, Color> = unspecified(),
    val onBackgroundSecondary: Pair<Color, Color> = unspecified(),
    val secondaryOnBackground: Pair<Color, Color> = unspecified(),
    val error: Pair<Color, Color> = unspecified(),
    val onError: Pair<Color, Color> = unspecified(),
    val errorContainer: Pair<Color, Color> = unspecified(),
    val onErrorContainer: Pair<Color, Color> = unspecified(),
    val outline: Pair<Color, Color> = unspecified(),
    val outlineVariant: Pair<Color, Color> = unspecified(),
    val inverseSurface: Pair<Color, Color> = unspecified(),
    val inverseOnSurface: Pair<Color, Color> = unspecified(),
    val inversePrimary: Pair<Color, Color> = unspecified(),
    val shadow: Pair<Color, Color> = unspecified(),
    val scrim: Pair<Color, Color> = unspecified(),
    val separator: Pair<Color, Color> = unspecified(),
    val switchBorder: Pair<Color, Color> = unspecified(),
    val success: Pair<Color, Color> = unspecified()
) {
    val primaryHorizontalGradient: Brush
        get() = Brush.horizontalGradient(listOf(primary.first, secondary.first))

    companion object {
        private fun unspecified(): Pair<Color, Color> = Pair(Color.Unspecified, Color.Unspecified)
    }
}

// endregion


// region Color Scheme

private object AppColors {

    // 🟡 Lightest tones (backgrounds, surfaces)
    val Snow        = Color(0xFFFCFCFC) // pure white
    val Porcelain   = Color(0xFFF8F7F8) // card surface
    val Linen       = Color(0xFFF0EDF0) // nested surface
    val Mist        = Color(0xFFE7E7E9) // surfaceMuted (light)
    val Ash         = Color(0xFFCBCBCB) // placeholder (light)
    val Fog         = Color(0xFFB0B0B4) // subtitle / secondary (dark)

    // 🟠 Mid tones (text, decoration)
    val Stone       = Color(0xFF93939F) // empty state message
    val Slate       = Color(0xFF727277) // secondary label (light)
    val Granite     = Color(0xFF63636C) // onBackgroundText (dark)
    val Iron        = Color(0xFF56565C) // onBackgroundPlaceholder (dark)

    // 🔵 Darker surfaces and content backgrounds
    val CharcoalMuted = Color(0xFF2E3138) // surfaceMuted (dark)
    val SlateBlack    = Color(0xFF24272D) // surfaceVariant (dark)
    val Graphite      = Color(0xFF1D1F24) // surface (dark)
    val Charcoal      = Color(0xFF17181C) // primary background (dark)
}

internal val fullColorScheme = AppColor(
    primary = Pair(AppColors.Charcoal, AppColors.Snow),
    background = Pair(AppColors.Snow, AppColors.Charcoal),
    surface = Pair(AppColors.Porcelain, AppColors.Graphite),
    surfaceVariant = Pair(AppColors.Linen, AppColors.SlateBlack),
    surfaceMuted = Pair(AppColors.Mist, AppColors.CharcoalMuted),
    onBackgroundPlaceholder = Pair(AppColors.Ash, AppColors.Iron),
    onBackgroundText = Pair(AppColors.Stone, AppColors.Granite),
    onBackgroundSecondary = Pair(AppColors.Slate, AppColors.Fog),
    onSurfaceDisabled = Pair(AppColors.Ash, AppColors.Iron)
)

// endregion
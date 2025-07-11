package basicElements

import AppTheme
import IconButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

/**
 * Used for section titles in screens.
 *
 * Has a padding of paddingMedium to the bottom.
 */
@Composable
fun SectionHeader(
    text: StringResource,
    icon: DrawableResource? = null,
    modifier: Modifier = Modifier,
    iconAction: () -> Unit = {},
) {
    SectionHeader(stringResource(text), icon) { iconAction }
}

@Deprecated(
    message = "Use SectionHeader with StringResource instead for localisation.",
    replaceWith = ReplaceWith("SectionHeader(text = stringResourceId)")
)
@Composable
fun SectionHeader(
    text: String,
    icon: DrawableResource? = null,
    modifier: Modifier = Modifier,
    iconAction: () -> Unit = {},
) {
    Row(
        modifier = modifier.padding(bottom = AppTheme.dimen.paddingS).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = AppTheme.typography.sectionHeader,
            color = AppTheme.colorScheme.primary
        )
        if (icon != null) {
            IconButton(icon) { iconAction.invoke() }
        }
    }
}

package elements

import AppTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun Button(
    text: String, enabled: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier
) {
    val textColor =
        if (enabled) AppTheme.colorScheme.primary else AppTheme.colorScheme.onSurfaceDisabled

    Box(
        modifier = modifier.fillMaxWidth().height(56.dp).clip(RoundedCornerShape(16.dp))
            .background(AppTheme.colorScheme.surface)
            .clickable(enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text, color = textColor, style = AppTheme.typography.buttonText
        )
    }
}


@Composable
fun Button(
    text: StringResource, enabled: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier
) {
    val textColor =
        if (enabled) AppTheme.colorScheme.primary else AppTheme.colorScheme.onSurfaceDisabled

    Box(
        modifier = modifier.fillMaxWidth().height(56.dp).clip(RoundedCornerShape(16.dp))
            .background(AppTheme.colorScheme.surface)
            .clickable(enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(text), color = textColor, style = AppTheme.typography.buttonText
        )
    }
}

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun IconButton(
    iconResource: DrawableResource,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: Dp = 25.dp,
    enabledColor: Color = AppTheme.colorScheme.primary,
    disabledColor: Color = AppTheme.colorScheme.primary,
    onClick: () -> Unit,
) {
    IconButton(modifier = modifier.size(25.dp), onClick = onClick) {
        Icon(
            modifier = Modifier.size(size),
            painter = painterResource(iconResource),
            contentDescription = null,
            tint = if (enabled) enabledColor else disabledColor
        )
    }
}
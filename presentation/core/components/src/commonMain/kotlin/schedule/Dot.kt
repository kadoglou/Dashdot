package schedule

import AppTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import schedule.data.DotStatus

@Composable
fun Dot(
    status: DotStatus,
    size: Dp = 16.dp
) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .background(
                color = if (status == DotStatus.FILLED) AppTheme.colorScheme.primary
                else Color.Transparent
            )
            .border(
                width = 1.dp,
                color = AppTheme.colorScheme.primary,
                shape = CircleShape
            )
    ) {
        if (status == DotStatus.DOTTED) {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(size / 2)
                    .clip(CircleShape)
                    .background(
                        color = AppTheme.colorScheme.primary
                    )
                    .border(
                        width = 1.dp,
                        color = AppTheme.colorScheme.primary,
                        shape = CircleShape
                    )
            )
        }
    }
}

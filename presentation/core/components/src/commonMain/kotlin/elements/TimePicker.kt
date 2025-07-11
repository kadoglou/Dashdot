package elements

import AppTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import dev.darkokoa.datetimewheelpicker.WheelTimePicker
import dev.darkokoa.datetimewheelpicker.core.WheelPickerDefaults
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun TimePicker(
    modifier: Modifier = Modifier,
    size: DpSize = DpSize(250.dp, 250.dp),
    value: LocalTime? = null,
    onValueChange: (LocalTime) -> Unit,
) {
    val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).time
    WheelTimePicker(
        startTime = value ?: now,
        modifier = modifier.fillMaxWidth(),
        size = size,
        selectorProperties = WheelPickerDefaults.selectorProperties(enabled = false),
        textStyle = AppTheme.typography.timePicker,
        textColor = AppTheme.colorScheme.primary
    ) { snappedTime ->
        onValueChange(snappedTime)
    }
}
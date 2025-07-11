package schedule

import AppTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.Day
import schedule.data.DotStatus

@Composable
fun WeeklySchedule(
    selectedDays: HashSet<Day>,
    onDayClick: (Day) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Day.entries.forEach { day ->
            DayItem(
                label = day.shortName,
                status = if (day in selectedDays) DotStatus.FILLED else DotStatus.EMPTY,
                onClick = { onDayClick(day) }
            )
        }
    }
}

@Composable
private fun DayItem(
    modifier: Modifier = Modifier,
    label: String,
    status: DotStatus,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable { onClick() }.padding(horizontal = 0.dp)
    ) {
        Label(label)
        Dot(status)
    }
}

@Composable
private fun Label(label: String) {
    Text(
        modifier = Modifier.padding(bottom = AppTheme.dimen.paddingXS),
        text = label,
        style = AppTheme.typography.label,
        color = AppTheme.colorScheme.primary
    )
}



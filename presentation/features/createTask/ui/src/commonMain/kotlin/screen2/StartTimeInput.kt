package screen2

import AppTheme
import CreateTaskAction
import CreateTaskState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import elements.TimePicker

@Composable
internal fun StartTimeInput(
    state: CreateTaskState,
    onAction: (CreateTaskAction) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize().padding(top = AppTheme.dimen.paddingXS)) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(bottom = AppTheme.dimen.paddingXS),
            text = "Set a start time?",
            style = AppTheme.typography.subtitleText,
            textAlign = TextAlign.Center,
            color = AppTheme.colorScheme.onBackgroundSecondary
        )
        TimePicker(
            value = state.startTime,
            onValueChange = { onAction(CreateTaskAction.OnStartTimeChange(it)) })
    }
}
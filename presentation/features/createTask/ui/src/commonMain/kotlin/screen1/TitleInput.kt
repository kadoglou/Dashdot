package screen1

import CreateTaskAction
import CreateTaskState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import elements.MinimalTextField

@Composable
internal fun TitleInput(
    state: CreateTaskState,
    onAction: (CreateTaskAction) -> Unit,
) {
    MinimalTextField(
        modifier = Modifier.fillMaxWidth(),
        value = state.title,
        onValueChange = { onAction(CreateTaskAction.OnTitleChangeValue(it)) },
    )
}

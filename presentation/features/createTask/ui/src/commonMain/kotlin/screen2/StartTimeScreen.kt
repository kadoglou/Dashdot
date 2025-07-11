package screen2

import AppTheme
import CreateTaskAction
import CreateTaskEndTimeDestination
import CreateTaskScheduleDestination
import CreateTaskState
import CreateTaskViewModel
import LocalRootNavController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import composables.CreateTaskScreenColumn
import composables.CreateTaskTopPartColumn
import composables.InfoPart
import elements.Button

@Composable
internal fun StartTimeScreenRoot(
    localNavController: NavHostController,
    viewModel: CreateTaskViewModel,
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    val rootNavController = LocalRootNavController.current

    StartTimeScreen(state) { action ->
        when (action) {
            is CreateTaskAction.RootNavigateBack -> {
                rootNavController.popBackStack()
            }

            is CreateTaskAction.NavigateTo -> {
                localNavController.navigate(action.route)
            }

            else -> viewModel.onAction(action)
        }
    }
}

@Composable
internal fun StartTimeScreen(
    state: CreateTaskState,
    onAction: (CreateTaskAction) -> Unit,
) {
    CreateTaskScreenColumn {
        CreateTaskTopPartColumn {
            LocalInfoPart(state)
            StartTimeInput(state, onAction)
        }
        ButtonsPart(state, onAction)
    }
}


@Composable
private fun ColumnScope.LocalInfoPart(
    state: CreateTaskState,
) {
    InfoPart {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = state.title,
            style = AppTheme.typography.createTaskTitle,
            textAlign = TextAlign.Center,
            color = AppTheme.colorScheme.primary
        )
    }
}

@Composable
private fun ButtonsPart(
    state: CreateTaskState,
    onAction: (CreateTaskAction) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Button(
            modifier = Modifier.weight(1f),
            text = AppStrings.SKIP,
            enabled = true,
            onClick = {
                onAction(CreateTaskAction.OnStartTimeChange(null))
                onAction(CreateTaskAction.NavigateTo(CreateTaskScheduleDestination))
            }
        )

        Button(
            modifier = Modifier.weight(1f),
            text = AppStrings.NEXT,
            enabled = state.title.isNotBlank(),
            onClick = { onAction(CreateTaskAction.NavigateTo(CreateTaskEndTimeDestination)) }
        )
    }
}
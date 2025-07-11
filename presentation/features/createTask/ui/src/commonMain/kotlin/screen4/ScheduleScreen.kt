package screen4

import AppStrings
import AppTheme
import CreateTaskAction
import CreateTaskState
import CreateTaskViewModel
import schedule.WeeklySchedule
import LocalRootNavController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import composables.CreateTaskScreenColumn
import composables.CreateTaskTopPartColumn
import composables.InfoPart
import data.TaskDto
import elements.Button
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun ScheduleScreenRoot(
    localNavController: NavHostController,
    viewModel: CreateTaskViewModel,
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    val rootNavController = LocalRootNavController.current

    ScheduleScreen(state) { action ->
        when (action) {
            is CreateTaskAction.RootNavigateTo -> {
                rootNavController.navigate(action.route)
            }

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
internal fun ScheduleScreen(
    state: CreateTaskState,
    onAction: (CreateTaskAction) -> Unit,
) {
    CreateTaskScreenColumn {
        CreateTaskTopPartColumn {
            LocalInfoPart(state)
            LocalInputPart(state, onAction)
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
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = AppTheme.dimen.paddingXXL),
            horizontalArrangement = Arrangement.Center,
        ) {
            if (state.startTimeString.isNotBlank()) {
                Text(
                    modifier = Modifier,
                    text = state.startTimeString,
                    style = AppTheme.typography.subtitleText,
                    textAlign = TextAlign.Center,
                    color = AppTheme.colorScheme.primary
                )
            }

            if (state.endTimeString.isNotBlank()) {
                Text(
                    modifier = Modifier,
                    text = " - " + state.endTimeString,
                    style = AppTheme.typography.subtitleText,
                    textAlign = TextAlign.Center,
                    color = AppTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun LocalInputPart(
    state: CreateTaskState,
    onAction: (CreateTaskAction) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize().padding(top = AppTheme.dimen.paddingXS)) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(bottom = AppTheme.dimen.paddingXXL),
            text = stringResource(AppStrings.SCHEDULE),
            style = AppTheme.typography.subtitleText,
            textAlign = TextAlign.Center,
            color = AppTheme.colorScheme.onBackgroundSecondary
        )

        WeeklySchedule(
            modifier = Modifier.padding(horizontal = AppTheme.dimen.paddingL),
            selectedDays = state.selectedDays,
            onDayClick = { day -> onAction(CreateTaskAction.ChangeDay(day)) }
        )
    }
}

@Composable
private fun ButtonsPart(
    state: CreateTaskState,
    onAction: (CreateTaskAction) -> Unit,
) {
    Button(
        text = "Done",
        enabled = state.title.isNotBlank(),
        onClick = {
            val taskDto = TaskDto(
                title = state.title,
                startTime = state.startTime,
                endTime = state.endTime,
                days = state.selectedDays
            )
            onAction(CreateTaskAction.SaveTask(taskDto))
            onAction(CreateTaskAction.RootNavigateBack)
        }
    )
}



package screen1

import CreateTaskAction
import CreateTaskStartTimeDestination
import CreateTaskState
import CreateTaskViewModel
import LocalRootNavController
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import composables.CreateTaskScreenColumn
import composables.CreateTaskTopPartColumn
import composables.InfoPart
import elements.Button

@Composable
internal fun TitleScreenRoot(
    localNavController: NavHostController,
    viewModel: CreateTaskViewModel,
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    val rootNavController = LocalRootNavController.current

    TitleScreen(state) { action ->
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
internal fun TitleScreen(
    state: CreateTaskState,
    onAction: (CreateTaskAction) -> Unit,
) {
    CreateTaskScreenColumn {
        CreateTaskTopPartColumn {
            InfoPart {}
            TitleInput(state, onAction)
        }
        ButtonsPart(state, onAction)
    }
}

@Composable
private fun ButtonsPart(
    state: CreateTaskState,
    onAction: (CreateTaskAction) -> Unit,
) {
    Button(
        text = AppStrings.NEXT,
        enabled = state.title.isNotBlank(),
        onClick = { onAction(CreateTaskAction.NavigateTo(CreateTaskStartTimeDestination)) }
    )
}

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import elements.Button
import elements.MinimalTextField
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import screen.Screen

@Composable
internal fun CreateStepScreenRoot(
    taskId: String,
    viewModel: CreateStepViewModel = koinViewModel(
        parameters = { parametersOf(taskId) }
    ),
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    val rootNavController = LocalRootNavController.current

    val localNavController = LocalNavController.current

    CreateStepScreen(state) { action ->
        when (action) {
            is CreateStepAction.NavigateBack -> {
                localNavController.popBackStack()
            }

            else -> viewModel.onAction(action)
        }
    }
}

@Composable
internal fun CreateStepScreen(
    state: CreateStepState,
    onAction: (CreateStepAction) -> Unit,
) {
    Screen {
        MinimalTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.step.description,
            onValueChange = { onAction(CreateStepAction.OnDescriptionChangeValue(it)) },
        )
        Button(
            text = AppStrings.NEXT,
            enabled = state.step.description.isNotBlank(),
            onClick = {
                onAction(CreateStepAction.OnSaveStep(state.step))
                onAction(CreateStepAction.NavigateBack)
            }
        )
    }
}
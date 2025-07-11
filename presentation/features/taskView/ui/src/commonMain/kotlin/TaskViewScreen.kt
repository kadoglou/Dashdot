import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import basicElements.PaddingS
import basicElements.PaddingXL
import basicElements.SectionHeader
import data.Step
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import schedule.WeeklySchedule
import screen.Screen

@Composable
internal fun TaskViewScreenRoot(
    taskId: String,
    viewModel: TaskViewViewModel = koinViewModel(
        parameters = { parametersOf(taskId) }
    ),
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    val rootNavController = LocalRootNavController.current
    val navController = LocalNavController.current

    TaskViewScreen(state) { action ->
        when (action) {
            is TaskViewAction.RootNavigateTo -> {
                rootNavController.navigate(action.route)
            }

            is TaskViewAction.NavigateTo -> {
                navController.navigate(action.route)
            }

            is TaskViewAction.NavigateBack -> {
                navController.popBackStack()
            }

            else -> viewModel.onAction(action)
        }
    }
}

@Composable
internal fun TaskViewScreen(
    state: TaskViewState,
    onAction: (TaskViewAction) -> Unit,
) {
    Screen(topBar = {
        IconButton(AppIcons.Back_Stack_Icon) {
            onAction(TaskViewAction.NavigateBack)
        }
        Text(
            text = state.taskDto?.title ?: "",
            style = AppTheme.typography.screenMediumTitle,
            color = AppTheme.colorScheme.primary
        )
    }) {
        PaddingS()

        SectionHeader(AppStrings.SECTION_WEEKLY_SCHEDULE)
        WeeklySchedule(
            selectedDays = state.taskDto?.days ?: hashSetOf(),
            onDayClick = { }
        )

        PaddingXL()

        SectionHeader(AppStrings.SECTION_NOTE, AppIcons.Edit_Icon)
        val text = remember { mutableStateOf("") }
        EditableNote(text.value) { text.value = it }


        PaddingXL()

        SectionHeader(
            "Checkboxes",
            icon = AppIcons.Plus_Icon_In_Circle
        ) {
            onAction(
                TaskViewAction.NavigateTo(
                    CreateStepDestination(
                        state.taskDto?.id ?: ""
                    )
                )
            )
        }
        StepList(state.taskDto?.steps ?: emptyList()) {}

    }
}

@Composable
fun StepList(
    steps: List<Step>,
    onStepClick: (Step) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        steps.forEach { step ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onStepClick(step) }
            ) {
                SubListTitle(step.description)
                ThinDivider()
            }
        }
    }
}

@Composable
fun SubListTitle(title: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = title,
        style = AppTheme.typography.subListTitle,
        color = AppTheme.colorScheme.primary,
        textAlign = TextAlign.Start
    )
}

@Composable
fun ThinDivider() {
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        color = AppTheme.colorScheme.primary,
        thickness = (0.3).dp
    )
}
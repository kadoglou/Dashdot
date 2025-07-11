import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import data.TaskDto
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import screen.ScreenNotScrollable

@Composable
internal fun TasksScreenRoot(
    viewModel: TasksViewModel = koinViewModel(),
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    val rootNavController = LocalRootNavController.current
    val navController = LocalNavController.current

    TasksScreen(state) { action ->
        when (action) {
            is TasksAction.RootNavigateTo -> {
                rootNavController.navigate(action.route)
            }

            is TasksAction.NavigateTo -> {
                navController.navigate(action.route)
            }

            else -> viewModel.onAction(action)
        }
    }
}

@Composable
internal fun TasksScreen(
    state: TasksState,
    onAction: (TasksAction) -> Unit,
) {
    ScreenNotScrollable {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(AppStrings.TASKS_SCREEN_TITLE),
                style = AppTheme.typography.screenLargeTitle,
                color = AppTheme.colorScheme.primary
            )
            IconButton(iconResource = AppIcons.Plus_Icon_In_Circle) {
                onAction(TasksAction.RootNavigateTo(CreateTaskDestination))
            }
        }
        TaskList(state.taskDtos) { onAction(TasksAction.NavigateTo(TaskViewDestination(it.id ?: ""))) }
    }
}

@Composable
fun TaskList(
    taskDtos: List<TaskDto>,
    onTaskClick: (TaskDto) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(top = 30.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        items(taskDtos) { task ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onTaskClick(task) }
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = task.title,
                        style = AppTheme.typography.taskTitleList,
                        color = AppTheme.colorScheme.primary
                    )
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(AppIcons.Front_Stack_Icon),
                        contentDescription = null,
                        tint = AppTheme.colorScheme.primary
                    )
                }
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    color = AppTheme.colorScheme.primary,
                    thickness = (0.5).dp
                )
            }
        }
    }
}
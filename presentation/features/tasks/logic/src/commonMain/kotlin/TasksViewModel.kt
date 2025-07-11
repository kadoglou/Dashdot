import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kitos14.tools.Destination
import data.TaskDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface TasksAction {
    data class RootNavigateTo(val route: Destination) : TasksAction
    data class NavigateTo(val route: Destination) : TasksAction
}

data class TasksState(
    val taskDtos: List<TaskDto> = emptyList(),
)

class TasksViewModel(
    private val taskRepository: TaskRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(TasksState())
    val state = _state.asStateFlow()

    init {
        // Collect tasks and update state
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.getTasks().collect { tasks ->
                _state.update { it.copy(taskDtos = tasks) }
            }
        }
    }

    fun onAction(action: TasksAction) {
        when (action) {
            is TasksAction.RootNavigateTo -> {}
            is TasksAction.NavigateTo -> {}
        }
    }
}

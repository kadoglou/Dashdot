import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kitos14.tools.Destination
import data.TaskDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface TaskViewAction {
    data class RootNavigateTo(val route: Destination) : TaskViewAction
    data class NavigateTo(val route: Destination) : TaskViewAction
    data object NavigateBack : TaskViewAction
}

data class TaskViewState(
    val taskDto: TaskDto? = null,
)

@OptIn(ExperimentalCoroutinesApi::class)
class TaskViewViewModel(
    private val taskId: String,
    private val taskRepository: TaskRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(TaskViewState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            taskRepository.getTask(taskId).collect { task ->
                _state.update { it.copy(taskDto = task) }
            }
        }
    }

    fun onAction(action: TaskViewAction) {
        when (action) {
            is TaskViewAction.RootNavigateTo -> {}
            is TaskViewAction.NavigateTo -> {}
            is TaskViewAction.NavigateBack -> {}
        }
    }
}

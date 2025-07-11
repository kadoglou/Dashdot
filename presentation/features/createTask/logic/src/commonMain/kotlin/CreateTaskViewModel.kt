import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kitos14.tools.Destination
import data.Day
import data.TaskDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalTime
import kotlinx.datetime.format.char

sealed interface CreateTaskAction {
    data class RootNavigateTo(val route: Destination) : CreateTaskAction
    data object RootNavigateBack : CreateTaskAction
    data class NavigateTo(val route: Destination) : CreateTaskAction
    data object NavigateBack : CreateTaskAction
    data class OnTitleChangeValue(val text: String) : CreateTaskAction
    data class OnStartTimeChange(val time: LocalTime? = null) : CreateTaskAction
    data class OnEndTimeChange(val time: LocalTime? = null) : CreateTaskAction
    data class ChangeDay(val day: Day) : CreateTaskAction
    data class SaveTask(val taskDto: TaskDto) : CreateTaskAction
}

data class CreateTaskState(
    val title: String = "",
    val startTime: LocalTime? = null,
    val startTimeString: String = "",
    val endTime: LocalTime? = null,
    val endTimeString: String = "",
    val selectedDays: HashSet<Day> = hashSetOf()
)

class CreateTaskViewModel(
    private val taskRepository: TaskRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(CreateTaskState())
    val state = _state.asStateFlow()

    fun onAction(action: CreateTaskAction) {
        when (action) {
            is CreateTaskAction.RootNavigateTo -> {}
            is CreateTaskAction.RootNavigateBack -> {}
            is CreateTaskAction.NavigateTo -> {}
            is CreateTaskAction.NavigateBack -> {}
            is CreateTaskAction.OnTitleChangeValue -> {
                _state.update { it.copy(title = action.text) }
            }

            is CreateTaskAction.OnStartTimeChange -> {
                _state.update {
                    if (action.time != null) {
                        it.copy(
                            startTime = action.time,
                            startTimeString = action.time.toCustomString(),
                        )
                    } else {
                        it.copy(
                            startTimeString = "",
                            endTimeString = ""
                        )
                    }
                }
            }


            is CreateTaskAction.OnEndTimeChange -> {
                _state.update {
                    if (action.time != null) {
                        it.copy(
                            endTime = action.time,
                            endTimeString = action.time.toCustomString()
                        )
                    } else {
                        it.copy(
                            endTimeString = ""
                        )
                    }
                }
            }

            is CreateTaskAction.ChangeDay -> {
                _state.update {
                    val currentDays = it.selectedDays.toMutableSet()
                    if (currentDays.contains(action.day)) {
                        currentDays.remove(action.day)
                    } else {
                        currentDays.add(action.day)
                    }
                    it.copy(selectedDays = currentDays.toHashSet())
                }
            }

            is CreateTaskAction.SaveTask -> {
                viewModelScope.launch(Dispatchers.IO) {
                    taskRepository.saveTask(action.taskDto)
                }
            }
        }
    }

    private val format = LocalTime.Format {
        amPmHour()      // Hour in 12-hour format
        char(':')
        minute()        // Minutes
        char(' ')
        amPmMarker("am", "pm") // AM/PM marker
    }

    private fun LocalTime.toCustomString() = format.format(this)

}

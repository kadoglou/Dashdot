import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kitos14.tools.Destination
import data.Step
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface CreateStepAction {
    data class RootNavigateTo(val route: Destination) : CreateStepAction
    data object NavigateBack : CreateStepAction
    data class OnDescriptionChangeValue(val text: String) : CreateStepAction
    data class OnSaveStep(val step: Step) : CreateStepAction
}

data class CreateStepState(
    val step: Step = Step(description = ""),
)

class CreateStepViewModel(
    private val taskId: String,
    private val setTaskStepUC: SetTaskStepUC,
) : ViewModel() {

    private val _state = MutableStateFlow(CreateStepState())
    val state = _state.asStateFlow()

    fun onAction(action: CreateStepAction) {
        when (action) {

            is CreateStepAction.RootNavigateTo -> {}

            is CreateStepAction.NavigateBack -> {}

            is CreateStepAction.OnDescriptionChangeValue -> {
                _state.update {
                    it.copy(step = it.step.copy(description = action.text))
                }
            }

            is CreateStepAction.OnSaveStep -> {
                addStep(action.step, taskId)
            }
        }
    }

    fun addStep(step: Step, taskId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            setTaskStepUC(taskId = taskId, step = step)
        }
    }

}

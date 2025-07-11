import androidx.lifecycle.ViewModel
import com.kitos14.tools.Destination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed interface HomeAction {
    data class RootNavigateTo(val route: Destination) : HomeAction
    data class NavigateTo(val route: Destination) : HomeAction
}

data class HomeState(
    val placeHolderSample: String? = null,
)

class HomeViewModel() : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.RootNavigateTo -> {}
            is HomeAction.NavigateTo -> {}
        }
    }
}

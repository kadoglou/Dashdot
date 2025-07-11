package rootScreen

import CreateTaskAction
import CreateTaskTitleDestination
import CreateTaskViewModel
import LocalRootNavController
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kitos14.tools.toDestination
import org.koin.compose.viewmodel.koinViewModel
import screen.FullScreen

@Composable
internal fun CreateTaskScreenRoot(
    viewModel: CreateTaskViewModel = koinViewModel(),
) {
    val rootNavController = LocalRootNavController.current

    val localNavController = rememberNavController()

    // region Top bar back button

    /**
     * When we are at the first screen where we set the title we don't want to show the back button
     * since it doesn't make sense. We already have the close button. When we are deeper in setting
     * a new task, we only then show the back button
     */
    val showBackButton = remember { mutableStateOf(false) }

    LaunchedEffect(localNavController) {
        localNavController.currentBackStackEntryFlow.collect {
            val currentDestination = it.destination.route?.toDestination()
            showBackButton.value = currentDestination != CreateTaskTitleDestination
        }
    }

    // endregion

    CreateTaskScreen(showBackButton, localNavController, viewModel) { action ->
        when (action) {
            is CreateTaskAction.RootNavigateTo -> {
                rootNavController.navigate(action.route)
            }

            is CreateTaskAction.RootNavigateBack -> {
                rootNavController.popBackStack()
            }

            is CreateTaskAction.NavigateBack -> {
                localNavController.popBackStack()
            }

            else -> viewModel.onAction(action)
        }
    }
}

@Composable
internal fun CreateTaskScreen(
    showBackButton: MutableState<Boolean>,
    localNavController: NavHostController,
    viewModel: CreateTaskViewModel,
    onAction: (CreateTaskAction) -> Unit,
) {
    FullScreen {
        TopBar(showBackButton, onAction)
        CreateTaskNavHost(
            Modifier.padding(top = AppTheme.dimen.paddingL).fillMaxSize().weight(1f),
            localNavController,
            viewModel
        )
    }
}



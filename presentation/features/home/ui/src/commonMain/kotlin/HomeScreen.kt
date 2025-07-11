import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import screen.Screen

@Composable
internal fun HomeScreenRoot(
    viewModel: HomeViewModel = koinViewModel(),
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    val rootNavController = LocalRootNavController.current
    val navController = LocalNavController.current

    HomeScreen(state) { action ->
        when (action) {
            is HomeAction.RootNavigateTo -> {
                rootNavController.navigate(action.route)
            }

            is HomeAction.NavigateTo -> {
                navController.navigate(action.route)
            }

            else -> viewModel.onAction(action)
        }
    }
}

@Composable
internal fun HomeScreen(
    state: HomeState,
    onAction: (HomeAction) -> Unit,
) {
    Screen {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(AppStrings.OVERVIEW_SCREEN_TITLE),
                style = AppTheme.typography.screenLargeTitle,
                color = AppTheme.colorScheme.primary
            )
            IconButton(iconResource = AppIcons.Notification_Bell) {

            }
        }
    }
}

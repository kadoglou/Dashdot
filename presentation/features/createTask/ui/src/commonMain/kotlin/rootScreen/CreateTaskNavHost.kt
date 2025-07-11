package rootScreen

import CreateTaskEndTimeDestination
import CreateTaskScheduleDestination
import CreateTaskStartTimeDestination
import CreateTaskTitleDestination
import CreateTaskViewModel
import screen3.EndTimeScreenRoot
import screen4.ScheduleScreenRoot
import screen2.StartTimeScreenRoot
import screen1.TitleScreenRoot
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
internal fun CreateTaskNavHost(
    modifier: Modifier,
    localNavController: NavHostController,
    viewModel: CreateTaskViewModel,
) {
    NavHost(
        modifier = modifier,
        navController = localNavController,
        startDestination = CreateTaskTitleDestination,
//        enterTransition = { EnterTransition.None },
//        exitTransition = { ExitTransition.None },
//        popEnterTransition = { EnterTransition.None },
//        popExitTransition = { ExitTransition.None }
    ) {
        composable<CreateTaskTitleDestination> {
            TitleScreenRoot(localNavController, viewModel)
        }

        composable<CreateTaskStartTimeDestination> {
            StartTimeScreenRoot(localNavController, viewModel)
        }

        composable<CreateTaskEndTimeDestination> {
            EndTimeScreenRoot(localNavController, viewModel)
        }

        composable<CreateTaskScheduleDestination> {
            ScheduleScreenRoot(localNavController, viewModel)
        }
    }
}
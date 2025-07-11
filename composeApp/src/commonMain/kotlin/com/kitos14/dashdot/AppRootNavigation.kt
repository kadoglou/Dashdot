package com.kitos14.dashdot

import AppDestination
import AppTheme
import AuthenticationDestination
import MultiTabDestination
import SignDestination
import Tab1Destination
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import appScreenGraph
import com.kitos14.tools.Destination
import createStepGraph
import createTaskGraph
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import homeGraph
import signGraph
import taskViewGraph
import tasksGraph

/**
 * The starting navigation of the app.
 * This NavHost uses the RootNavController, and is mostly used to navigate between graphs that
 * should not be easily accessed. Like splitting the authorization screen from the rest of the screen.
 */
@Composable
fun AppRootNavigation(
    rootNavController: NavHostController,
    tabsState: MutableState<List<Destination>>
) {
    val backgroundColor = AppTheme.colorScheme.background
    val tabs = getTabs()
    AuthStateWatcher(rootNavController)
    NavHost(
        navController = rootNavController,
        startDestination = if (Firebase.auth.currentUser != null) AppDestination else AuthenticationDestination,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        // Authentication Screen, only showing up when user is not logged in
        navigation<AuthenticationDestination>(
            startDestination = SignDestination
        ) {
            signGraph().invoke(this)
        }

        // Main App - With tabs
        navigation<AppDestination>(
            startDestination = MultiTabDestination,
        ) {
            appScreenGraph(
                tabsState = tabsState,
                homeTabDestination = Tab1Destination,
                tabs = tabs,
                tabGraphBuilder = listOf(
                    createStepGraph(),
                    createTaskGraph(),
                    homeGraph(),
                    tasksGraph(),
                    taskViewGraph(),
                ),
                backgroundColor = backgroundColor,
                onBackgroundColor = backgroundColor,
            ).invoke(this)
        }

        createTaskGraph().invoke(this)

        // Single Tasks Screen

    }
}


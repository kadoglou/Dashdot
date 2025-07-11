package com.kitos14.dashdot

import AppDestination
import AuthenticationDestination
import MultiTabDestination
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.kitos14.tools.toDestination
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth

/**
 * Used to constantly check if the used logs out, he should be get a feedback of the authentication state
 * instantly.
 */
@Composable
fun AuthStateWatcher(rootNavController: NavHostController) {
    LaunchedEffect(Unit) {
        Firebase.auth.authStateChanged.collect { user ->
            if (user == null) {
                rootNavController.navigate(AuthenticationDestination) {
                    popUpTo(0) { inclusive = true }
                    launchSingleTop = true
                }
            } else {
                if (rootNavController.currentBackStackEntry?.destination?.route?.toDestination() != MultiTabDestination)
                    rootNavController.navigate(AppDestination) {
                        popUpTo(0) { inclusive = true }
                        launchSingleTop = true
                    }
            }
        }
    }
}
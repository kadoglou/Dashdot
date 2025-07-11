package com.kitos14.dashdot

import AppTheme
import LocalRootNavController
import Tab1Destination
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import com.mmk.kmpauth.google.GoogleAuthProvider
import org.koin.compose.koinInject
import rememberMultiTabState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val googleAuthProvider: GoogleAuthProvider = koinInject()
    val rootNavController = rememberNavController()
    val tabsState = rememberMultiTabState(initialTabs = listOf(Tab1Destination))
    CompositionLocalProvider(
        LocalRootNavController provides rootNavController,
        LocalRippleConfiguration provides null
    ) {
        AppTheme {
            AppRootNavigation(rootNavController, tabsState)
        }
    }
}
package com.kitos14.dashdot

import AppIcons
import AppTheme
import HomeDestination
import Tab1Destination
import Tab2Destination
import Tab3Destination
import Tab4Destination
import TasksDestination
import androidx.compose.runtime.Composable
import tabs.Tab

@Composable
internal fun getTabs(): List<Tab> {
    val home = Tab(
        title = null,
        destination = Tab1Destination,
        startingDestination = HomeDestination,
        selectedIcon = AppIcons.Home_Selected,
        unselectedIcon = AppIcons.Home_Unselected,
        selectedTextStyle = AppTheme.typography.bottomNavigationTitleSelected,
        unselectedTextStyle = AppTheme.typography.bottomNavigationTitleUnselected,
        selectedColor = AppTheme.colorScheme.primary,
        unselectedColor = AppTheme.colorScheme.surfaceMuted,
    )

    val explore = Tab(
        title = null,
        destination = Tab2Destination,
        startingDestination = HomeDestination,
        selectedIcon = AppIcons.Home_Selected,
        unselectedIcon = AppIcons.Home_Unselected,
        selectedTextStyle = AppTheme.typography.bottomNavigationTitleSelected,
        unselectedTextStyle = AppTheme.typography.bottomNavigationTitleUnselected,
        selectedColor = AppTheme.colorScheme.primary,
        unselectedColor = AppTheme.colorScheme.surfaceMuted,
    )

    val tasks = Tab(
        title = null,
        destination = Tab3Destination,
        startingDestination = TasksDestination,
        selectedIcon = AppIcons.Tasks_Menu,
        unselectedIcon = AppIcons.Tasks_Menu,
        selectedTextStyle = AppTheme.typography.bottomNavigationTitleSelected,
        unselectedTextStyle = AppTheme.typography.bottomNavigationTitleUnselected,
        selectedColor = AppTheme.colorScheme.primary,
        unselectedColor = AppTheme.colorScheme.surfaceMuted,
    )

    val profile = Tab(
        title = null,
        destination = Tab4Destination,
        startingDestination = HomeDestination,
        selectedIcon = AppIcons.Home_Selected,
        unselectedIcon = AppIcons.Home_Unselected,
        selectedTextStyle = AppTheme.typography.bottomNavigationTitleSelected,
        unselectedTextStyle = AppTheme.typography.bottomNavigationTitleUnselected,
        selectedColor = AppTheme.colorScheme.primary,
        unselectedColor = AppTheme.colorScheme.surfaceMuted,
    )

    return listOf(home, explore, tasks, profile)
}

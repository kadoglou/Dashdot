package screen

import AppTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import preventInteractionOnLifecycle

@Composable
fun Screen(
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppTheme.colorScheme.background,
    topBar: @Composable RowScope.() -> Unit = {},
    context: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .preventInteractionOnLifecycle()
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
            .background(backgroundColor)
            .padding(horizontal = AppTheme.dimen.paddingL)
    ) {
        ScreenTopBar {
            topBar()
        }
        ScreenContent {
            context()
        }
    }
}

@Composable
private fun ScreenTopBar(
    context: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        context()
    }
}


@Composable
private fun ScreenContent(
    context: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        context()
    }
}

@Composable
fun ScreenNotScrollable(
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppTheme.colorScheme.background,
    context: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .preventInteractionOnLifecycle()
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
            .background(backgroundColor)
            .padding(start = AppTheme.dimen.paddingL, end = AppTheme.dimen.paddingL)
    ) {
        context()
    }
}

@Composable
fun FullScreen(
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppTheme.colorScheme.background,
    context: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .preventInteractionOnLifecycle()
            .fillMaxSize()
            .background(backgroundColor)
            .windowInsetsPadding(WindowInsets.statusBars)
            .padding(
                start = AppTheme.dimen.paddingL,
                end = AppTheme.dimen.paddingL,
                bottom = AppTheme.dimen.paddingL
            )
            .verticalScroll(rememberScrollState())
    ) {
        context()
    }
}

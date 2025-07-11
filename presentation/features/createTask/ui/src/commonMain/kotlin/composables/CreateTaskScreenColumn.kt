package composables

import AppTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun CreateTaskScreenColumn(context: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        context()
    }
}

@Composable
internal fun ColumnScope.CreateTaskTopPartColumn(
    context: @Composable ColumnScope.() -> Unit
) {
    Column(modifier = Modifier.weight(1f).fillMaxSize()) {
        context()
    }
}

@Composable
internal fun ColumnScope.InfoPart(
    context: @Composable ColumnScope.() -> Unit
) {

    Column(
        modifier = Modifier.height(AppTheme.dimen.createTaskInfoHeight).fillMaxWidth()
    ) {
        context()
    }
}


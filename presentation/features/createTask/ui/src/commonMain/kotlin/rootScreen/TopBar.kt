package rootScreen

import AppIcons
import CreateTaskAction
import IconButton
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    showBackButton: MutableState<Boolean>,
    onAction: (CreateTaskAction) -> Unit,
) {
    Box(modifier = Modifier.fillMaxWidth().height(AppTheme.dimen.topBarHeight)) {
        if (showBackButton.value) {
            IconButton(
                modifier = Modifier.align(Alignment.CenterStart),
                iconResource = AppIcons.Back_Icon,
            ) {
                onAction(CreateTaskAction.NavigateBack)
            }
        }
        IconButton(
            modifier = Modifier.align(Alignment.CenterEnd),
            iconResource = AppIcons.Close_X_Icon,
        ) {
            onAction(CreateTaskAction.RootNavigateBack)
        }
    }
}
package basicElements

import AppTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp


@Composable
fun PaddingXS() {
    Padding(AppTheme.dimen.paddingXS)
}

@Composable
fun PaddingS() {
    Padding(AppTheme.dimen.paddingS)
}

@Composable
fun PaddingL() {
    Padding(AppTheme.dimen.paddingL)
}


@Composable
fun PaddingXL() {
    Padding(AppTheme.dimen.paddingXL)
}

@Composable
fun PaddingXXL() {
    Padding(AppTheme.dimen.paddingXXL)
}

@Composable
private fun Padding(
    height: Dp,
) {
    Spacer(
        modifier = Modifier.height(height)
    )
}


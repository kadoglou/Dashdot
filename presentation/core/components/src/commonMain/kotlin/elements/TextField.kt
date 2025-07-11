package elements

import AppTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

@Composable
fun MinimalTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "Title",
) {
    Column(modifier = modifier) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = if (value.isEmpty()) AppTheme.typography.createTaskTitlePlaceholder.copy(
                color = AppTheme.colorScheme.onBackgroundPlaceholder
            ) else AppTheme.typography.createTaskTitle.copy(color = AppTheme.colorScheme.primary),
            cursorBrush = SolidColor(AppTheme.colorScheme.primary),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp)
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = AppTheme.typography.createTaskTitlePlaceholder,
                            color = AppTheme.colorScheme.onBackgroundPlaceholder
                        )
                    }
                    innerTextField()
                }
            })

        HorizontalDivider(
            color = if (value.isEmpty()) AppTheme.colorScheme.onBackgroundPlaceholder else AppTheme.colorScheme.primary,
            thickness = 1.dp
        )
    }
}


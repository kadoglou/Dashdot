import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun NoteSurface(
    modifier: Modifier = Modifier,
    height: Dp = 150.dp,
    innerPadding: PaddingValues = PaddingValues(),
    context: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .height(height)
            .background(AppTheme.colorScheme.surface)
    ) {
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            context()
        }
    }
}

@Composable
fun TextNoteSurface(text: String?) {
    NoteSurface(innerPadding = PaddingValues(AppTheme.dimen.paddingXS)) {
        Text(
            text = text ?: "",
            style = AppTheme.typography.noteParagraph,
            color = AppTheme.colorScheme.onBackgroundSecondary
        )
    }
}
@Composable
fun EditableNoteSurface(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    minHeight: Dp = 150.dp,
    innerPadding: PaddingValues = PaddingValues(AppTheme.dimen.paddingXS)
) {
    NoteSurface(
        modifier = modifier,
        height = Dp.Unspecified, // Let content define height
        innerPadding = innerPadding
    ) {
        BasicTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = minHeight)
                .background(color = AppTheme.colorScheme.surface),
            textStyle = AppTheme.typography.noteParagraph.copy(
                color = AppTheme.colorScheme.onBackgroundSecondary
            ),
            maxLines = Int.MAX_VALUE,
            singleLine = false,
        )
    }
}

@Composable
fun EditableNote(
    note: String,
    onNoteChange: (String) -> Unit
) {
    EditableNoteSurface(
        text = note,
        onTextChange = onNoteChange
    )
}

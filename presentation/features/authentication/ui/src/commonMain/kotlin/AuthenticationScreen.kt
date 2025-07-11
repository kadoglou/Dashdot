import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mmk.kmpauth.google.GoogleButtonUiContainer
import dashdot.presentation.features.authentication.ui.generated.resources.Res
import dashdot.presentation.features.authentication.ui.generated.resources.google
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import screen.Screen

@Composable
internal fun AuthenticationScreenRoot(
    viewModel: AuthenticationViewModel = koinViewModel(),
) {
    val rootNavController = LocalRootNavController.current

    AuthenticationScreen { action ->
        when (action) {
            is AuthenticationAction.RootNavigateTo -> {
                rootNavController.navigate(action.route)
            }

            else -> viewModel.onAction(action)
        }
    }
}

@Composable
internal fun AuthenticationScreen(
    onAction: (AuthenticationAction) -> Unit,
) {
    Screen {
        GoogleButtonUiContainer(onGoogleSignInResult = { googleUser ->
            val idToken = googleUser?.idToken
            val accessToken = googleUser?.accessToken
            onAction(AuthenticationAction.SignIn(idToken, accessToken))
        }) {
            GoogleSignInButton(
                imagePainter = painterResource(Res.drawable.google),
                onClick = { this.onClick() })
        }
    }
}


@Composable
fun GoogleSignInButton(
    text: String = "Sign in with Google",
    imagePainter: Painter, // Pass in your loaded image
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "Google logo",
                modifier = Modifier
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Sign in with Google",
                fontSize = 18.sp,
                style = AppTheme.typography.headlineMedium
            )
        }
    }
}

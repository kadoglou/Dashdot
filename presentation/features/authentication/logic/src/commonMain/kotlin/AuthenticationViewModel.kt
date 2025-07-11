import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kitos14.tools.Destination
import kotlinx.coroutines.launch
import usecases.SignUserToFirebaseUC

sealed interface AuthenticationAction {
    data class RootNavigateTo(val route: Destination) : AuthenticationAction
    data class SignIn(val idToken: String?, val accessToken: String?) : AuthenticationAction
}

data class AuthenticationState(
    val placeHolderSample: String? = null,
)

class AuthenticationViewModel(
    private val signUserToFirebaseUC: SignUserToFirebaseUC,
) : ViewModel() {

    fun onAction(action: AuthenticationAction) {
        when (action) {
            is AuthenticationAction.RootNavigateTo -> {}
            is AuthenticationAction.SignIn -> {
                signIn(action.idToken, action.accessToken)
            }
        }
    }

    fun signIn(idToken: String?, accessToken: String?) {
        viewModelScope.launch {
            signUserToFirebaseUC.execute(idToken, accessToken)
        }
    }

}

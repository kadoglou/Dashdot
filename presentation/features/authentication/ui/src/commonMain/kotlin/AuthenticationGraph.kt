import androidx.navigation.NavGraphBuilder

fun signGraph(): NavGraphBuilder.() -> Unit = {
    animatableComposable<SignDestination> {
        AuthenticationScreenRoot()
    }
}

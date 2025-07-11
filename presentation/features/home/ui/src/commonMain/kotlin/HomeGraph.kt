import androidx.navigation.NavGraphBuilder

fun homeGraph(): NavGraphBuilder.() -> Unit = {
    animatableComposable<HomeDestination>() {
        HomeScreenRoot()
    }
}

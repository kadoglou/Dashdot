import androidx.navigation.NavGraphBuilder
import rootScreen.CreateTaskScreenRoot

fun createTaskGraph(): NavGraphBuilder.() -> Unit = {
    animatableComposable<CreateTaskDestination>(duration = 600) {
        CreateTaskScreenRoot()
    }
}

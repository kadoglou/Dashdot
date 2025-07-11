import androidx.navigation.NavGraphBuilder

fun tasksGraph(): NavGraphBuilder.() -> Unit = {
    animatableComposable<TasksDestination> {
        TasksScreenRoot()
    }
}

import androidx.navigation.NavGraphBuilder
import androidx.navigation.toRoute

fun taskViewGraph(): NavGraphBuilder.() -> Unit = {
    animatableComposable<TaskViewDestination> { entry ->
        val args = entry.toRoute<TaskViewDestination>()
        TaskViewScreenRoot(args.taskId)
    }
}

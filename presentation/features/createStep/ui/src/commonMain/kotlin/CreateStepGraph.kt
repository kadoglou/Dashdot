import androidx.navigation.NavGraphBuilder
import androidx.navigation.toRoute

fun createStepGraph(): NavGraphBuilder.() -> Unit = {
    animatableComposable<CreateStepDestination> { entry ->
        val args = entry.toRoute<CreateStepDestination>()
        CreateStepScreenRoot(args.taskId)
    }
}

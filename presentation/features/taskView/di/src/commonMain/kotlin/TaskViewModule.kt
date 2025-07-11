import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val taskViewFeatureModule = module {
    viewModel { (taskId: String) ->
        TaskViewViewModel(
            taskId = taskId,
            taskRepository = get()
        )
    }
}

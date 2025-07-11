import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val createStepFeatureModule = module {
    viewModel { (taskId: String) ->
        CreateStepViewModel(taskId, get())
    }
}

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val tasksFeatureModule = module {
    viewModelOf(::TasksViewModel)
}

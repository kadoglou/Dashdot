import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val createTaskFeatureModule = module {
    viewModelOf(::CreateTaskViewModel)
}

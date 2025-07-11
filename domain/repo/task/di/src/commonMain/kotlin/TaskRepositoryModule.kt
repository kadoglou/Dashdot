import di.taskRepositoryImplModule
import org.koin.dsl.module

val taskRepositoryModule = module {
    includes(taskRepositoryImplModule)
}

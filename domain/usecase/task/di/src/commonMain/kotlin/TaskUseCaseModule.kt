import di.taskUseCaseImplModule
import org.koin.dsl.module

val taskUseCaseModule = module {
    includes(taskUseCaseImplModule)
}

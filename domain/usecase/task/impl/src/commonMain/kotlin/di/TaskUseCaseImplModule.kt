package di

import SetTaskStepUC
import SetTaskStepUCImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val taskUseCaseImplModule = module {
    factoryOf(::SetTaskStepUCImpl).bind<SetTaskStepUC>()
}

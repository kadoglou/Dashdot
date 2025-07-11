package di

import TaskRepository
import TaskRepositoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val taskRepositoryImplModule = module {
    factoryOf(::TaskRepositoryImpl).bind<TaskRepository>()
}

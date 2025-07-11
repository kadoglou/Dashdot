package di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import usecases.SignUserToFirebaseUC
import usecases.SignUserToFirebaseUCImpl

val authenticationLogicModule = module {
    factoryOf(::SignUserToFirebaseUCImpl).bind<SignUserToFirebaseUC>()
}

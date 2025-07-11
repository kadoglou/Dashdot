import di.authenticationLogicModule
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authenticationFeatureModule = module {
    includes(authenticationLogicModule)
    viewModelOf(::AuthenticationViewModel)
}

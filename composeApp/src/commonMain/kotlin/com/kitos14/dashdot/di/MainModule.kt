package com.kitos14.dashdot.di

import com.mmk.kmpauth.google.GoogleAuthCredentials
import com.mmk.kmpauth.google.GoogleAuthProvider
import org.koin.dsl.module

val mainModule = module {
    single {
        GoogleAuthProvider.create(
            credentials = GoogleAuthCredentials(
                serverId = "422905428839-jhii9i3rr9ijvdf3usajgc6cm6pdu80m.apps.googleusercontent.com"
            )
        )
    }
}
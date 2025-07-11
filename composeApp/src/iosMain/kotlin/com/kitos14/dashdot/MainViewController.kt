package com.kitos14.dashdot

import androidx.compose.ui.window.ComposeUIViewController
import com.kitos14.dashdot.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }

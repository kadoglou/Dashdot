import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner

fun Modifier.preventInteractionOnLifecycle(): Modifier = composed {
    val lifecycleOwner = LocalLifecycleOwner.current

    pointerInput(lifecycleOwner) {
        val shouldBlock = mutableStateOf(false)

        // Set up lifecycle observer
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE, Lifecycle.Event.ON_STOP -> shouldBlock.value = true
                Lifecycle.Event.ON_RESUME, Lifecycle.Event.ON_START -> shouldBlock.value = false
                else -> Unit
            }
        }

        // Attach observer
        lifecycleOwner.lifecycle.addObserver(observer)

        awaitPointerEventScope {
            try {
                while (true) {
                    if (shouldBlock.value) {
                        awaitPointerEvent(pass = PointerEventPass.Initial)
                            .changes
                            .forEach { it.consume() }
                    } else {
                        awaitPointerEvent()
                    }
                }
            } finally {
                lifecycleOwner.lifecycle.removeObserver(observer)
            }
        }
    }
}


//@Composable
//fun rememberShouldBlockInput(): State<Boolean> {
//    val lifecycleOwner = LocalLifecycleOwner.current
//    val shouldBlock = remember { mutableStateOf(false) }
//
//    DisposableEffect(lifecycleOwner) {
//        val observer = LifecycleEventObserver { _, event ->
//            when (event) {
//                Lifecycle.Event.ON_PAUSE,
//                Lifecycle.Event.ON_STOP -> shouldBlock.value = true
//
//                Lifecycle.Event.ON_RESUME,
//                Lifecycle.Event.ON_START -> shouldBlock.value = false
//
//                else -> Unit
//            }
//        }
//
//        lifecycleOwner.lifecycle.addObserver(observer)
//
//        onDispose {
//            lifecycleOwner.lifecycle.removeObserver(observer)
//        }
//    }
//
//    return shouldBlock
//}

//@Composable
//fun rememberShouldBlockInput(lifecycleOwner: LifecycleOwner): State<Boolean> {
//    val shouldBlock = remember { mutableStateOf(false) }
//
//    DisposableEffect(lifecycleOwner) {
//        val observer = LifecycleEventObserver { _, event ->
//            when (event) {
//                Lifecycle.Event.ON_PAUSE, Lifecycle.Event.ON_STOP -> shouldBlock.value = true
//                Lifecycle.Event.ON_RESUME, Lifecycle.Event.ON_START -> shouldBlock.value = false
//                else -> Unit
//            }
//        }
//
//        lifecycleOwner.lifecycle.addObserver(observer)
//        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
//    }
//
//    return shouldBlock
//}
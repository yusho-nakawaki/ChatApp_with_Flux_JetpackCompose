package com.example.chatapp_flux_compose.login

import androidx.lifecycle.ViewModel
import com.example.chatapp_flux_compose.data.architecture.Dispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

class LoginStore(private val dispatcher: Dispatcher) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main + Job()

    init {
        dispatcher.register(this)
    }

    override fun onCleared() {
        cancel()
        dispatcher.unregister(this)
        super.onCleared()
    }
}
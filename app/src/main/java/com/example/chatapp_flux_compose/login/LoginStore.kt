package com.example.chatapp_flux_compose.login

import androidx.lifecycle.ViewModel
import com.example.chatapp_flux_compose.data.architecture.Dispatcher
import com.example.chatapp_flux_compose.data.general.StatusState
import com.example.chatapp_flux_compose.data.preference.UserPreference
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import org.greenrobot.eventbus.Subscribe
import kotlin.coroutines.CoroutineContext

class LoginStore(
    private val dispatcher: Dispatcher,
    private val userPreference: UserPreference,
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main + Job()

    private val mutableRegisterBasicUserInfoSucceed = MutableSharedFlow<Unit>()
    val registerBasicUserInfoSucceed: SharedFlow<Unit> = mutableRegisterBasicUserInfoSucceed

    private val mutableStatusState = MutableStateFlow<StatusState>(StatusState.None)
    val statusState: StateFlow<StatusState> = mutableStatusState

    init {
        dispatcher.register(this)
    }

    override fun onCleared() {
        cancel()
        dispatcher.unregister(this)
        super.onCleared()
    }

    @Subscribe
    fun on(event: LoginActionEvent.UploadUserIconSucceed) {
        userPreference.userIconUrl = event.iconUrl
        mutableStatusState.value = StatusState.None
    }

    @Subscribe
    fun on(event: LoginActionEvent.UploadUserIconFailed) {
        mutableStatusState.value = StatusState.Error(event.errorMessage ?: "error")
    }

    @Subscribe
    fun on(event: LoginActionEvent.RegisterBasicUserInfoSucceed) {
        launch {
            mutableRegisterBasicUserInfoSucceed.emit(Unit)
        }
    }



    @Subscribe
    fun on(event: LoginActionEvent.LoadingStatusState) {
        mutableStatusState.value = StatusState.Loading
    }

}
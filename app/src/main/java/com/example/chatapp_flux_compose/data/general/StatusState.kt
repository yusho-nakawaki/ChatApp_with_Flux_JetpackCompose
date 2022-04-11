package com.example.chatapp_flux_compose.data.general

sealed class StatusState {
    object None : StatusState()
    object Loading : StatusState()
    object LoadingNext : StatusState()
    object NotFound : StatusState()
    class Error(val errorMessage: String) : StatusState()

    val isLoading: Boolean
        get() = this is Loading || this is LoadingNext
}
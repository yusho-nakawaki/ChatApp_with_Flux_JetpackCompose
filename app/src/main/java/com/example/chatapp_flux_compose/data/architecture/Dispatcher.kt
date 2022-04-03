package com.example.chatapp_flux_compose.data.architecture

import android.util.Log
import com.example.chatapp_flux_compose.BuildConfig
import org.greenrobot.eventbus.EventBus

class Dispatcher {
    private val dispatcherBus: EventBus = EventBus.getDefault()

    fun dispatch(event: Any) {
        if (BuildConfig.DEBUG) {
            Log.d("Dispatcher", event.toString())
        }
        dispatcherBus.post(event)
    }

    fun register(observer: Any) {
        if (!dispatcherBus.isRegistered(observer)) {
            dispatcherBus.register(observer)
        } else {
//            Logger.errorf("Subscriber $observer already registered to event ")
        }
    }

    fun unregister(observer: Any) {
        if (dispatcherBus.isRegistered(observer)) {
            dispatcherBus.unregister(observer)
        } else {
//            Logger.errorf("Subscriber to unregister was not registered before: $observer")
        }
    }
}

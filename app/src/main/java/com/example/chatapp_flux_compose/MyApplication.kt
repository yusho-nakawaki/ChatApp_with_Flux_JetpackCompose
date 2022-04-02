package com.example.chatapp_flux_compose

import android.app.Application
import com.example.chatapp_flux_compose.data.preference.UserPreference
import com.example.chatapp_flux_compose.data.preference.UserPreferenceImpl
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    // DIで必要
    private fun setupKoin() {
        startKoin {
            modules(
                listOf(myModule)
            )
        }
    }

    /*
     single: シングルトンでモジュール宣言
     factory: モジュール宣言したクラスが必要になるたび、インスタンスを生成する
     viewModel: ViewModelのモジュール宣言で使用する
     */
    private val myModule = module {
        single<UserPreference> { UserPreferenceImpl(applicationContext) } // NOTE なぜget()ではクラッシュするのか
    }
}
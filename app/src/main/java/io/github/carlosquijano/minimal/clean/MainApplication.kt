package io.github.carlosquijano.minimal.clean

import android.app.Application
import android.util.Log
import com.carlosquijano.minimal.clean.data.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

private const val TAG = "MainApplication"

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(dataModule)
        }
        Log.d(TAG, "✅ Koin initialized")
    }
}
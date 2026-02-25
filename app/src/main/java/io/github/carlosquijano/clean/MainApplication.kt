package io.github.carlosquijano.clean

import android.app.Application
import android.util.Log
import com.carlosquijano.clean.data.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

private const val TAG = "MainApplication"

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Log.d(TAG, "🚀 Starting application")

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(dataModule)
        }

        Log.d(TAG, "✅ Koin initialized")
    }
}
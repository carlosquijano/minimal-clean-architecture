package io.github.carlosquijano.clean

import android.app.Application
import com.carlosquijano.clean.data.di.dataModule
import com.carlosquijano.clean.domain.Logger
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.getKoin

private const val TAG = "MainApplication"

class MainApplication : Application() {
    private lateinit var logger: Logger

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(dataModule)
        }
        getKoin().get<Logger>().d(TAG, "✅ Koin initialized")
    }
}
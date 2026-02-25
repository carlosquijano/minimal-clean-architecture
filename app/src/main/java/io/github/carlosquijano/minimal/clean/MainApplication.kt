package io.github.carlosquijano.minimal.clean

import android.app.Application
import com.carlosquijano.minimal.clean.data.di.dataModule
import com.carlosquijano.minimal.clean.domain.Logger
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

private const val TAG = "MainApplication"

class MainApplication : Application() {
    private val logger: Logger by inject()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(dataModule)
        }
        logger.d(TAG, "✅ Koin initialized")
    }
}
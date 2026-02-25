package io.github.carlosquijano.clean

import androidx.test.core.app.ApplicationProvider
import com.carlosquijano.clean.data.di.dataModule
import org.junit.After
import org.junit.Before
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

/**
 * Base class for all tests that need Koin dependency injection.
 * Handles Koin lifecycle automatically.
 */
abstract class BaseKoinTest(
    private val logLevel: Level = Level.DEBUG,
    private val useAndroidLogger: Boolean = true,
    private val extraModules: List<Module> = emptyList()
) {

    @Before
    open fun setupKoin() {
        stopKoin()

        startKoin {
            if (useAndroidLogger) {
                androidLogger(logLevel)
            }
            androidContext(ApplicationProvider.getApplicationContext())
            modules(listOf(dataModule) + extraModules)
        }
    }

    @After
    open fun tearDownKoin() {
        stopKoin()
    }
}

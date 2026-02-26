package com.carlosquijano.minimal.clean.data.di

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.verify.verify

class DataModuleTest : KoinTest {
    @Before
    fun setUp() {
        stopKoin()
        startKoin {
            modules(dataModule)
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun `verify all declared class constructors are bound`() {
        dataModule.verify()
    }
}
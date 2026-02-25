package com.carlosquijano.minimal.clean.data.di

import com.carlosquijano.minimal.clean.data.AndroidLogger
import com.carlosquijano.minimal.clean.domain.Logger
import org.koin.dsl.module

val loggerModule = module {
    single<Logger> { AndroidLogger() }
}
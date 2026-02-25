package com.carlosquijano.clean.data.di

import com.carlosquijano.clean.data.AndroidLogger
import com.carlosquijano.clean.domain.Logger
import org.koin.dsl.module

val loggerModule = module {
    single<Logger> { AndroidLogger() }
}
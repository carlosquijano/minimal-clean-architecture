package com.carlosquijano.clean.data.di

import org.koin.dsl.module

val dataModule = module {
    includes(roomModule, loggerModule)
}

package com.carlosquijano.minimal.clean.data.di

import org.koin.dsl.module

val dataModule = module {
    includes(roomModule)
}

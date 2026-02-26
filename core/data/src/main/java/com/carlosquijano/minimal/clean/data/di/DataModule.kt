package com.carlosquijano.minimal.clean.data.di

import org.koin.dsl.module

val roomModule = module {}

val dataModule = module {
    includes(roomModule)
}

package com.carlosquijano.clean.data.di

import android.util.Log
import org.koin.dsl.module

val dataModule = module {
    includes(roomModule, loggerModule)
}

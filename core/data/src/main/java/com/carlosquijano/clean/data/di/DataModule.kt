package com.carlosquijano.clean.data.di

import android.util.Log
import org.koin.dsl.module

private const val TAG = "RoomModule"

val roomModule = module {
    Log.d(TAG, "📦 Koin module for Room loaded")
    single(createdAtStart = true) {
        Log.d(TAG, "✅ Room is ready")
    }
}

val dataModule = module {
    includes(roomModule)
}

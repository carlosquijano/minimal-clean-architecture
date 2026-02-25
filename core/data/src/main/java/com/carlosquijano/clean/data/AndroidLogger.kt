package com.carlosquijano.clean.data

import android.util.Log
import com.carlosquijano.clean.domain.Logger

class AndroidLogger : Logger {
    override fun d(tag: String, message: String) {
        Log.d(tag, message)
    }

    override fun e(tag: String, message: String) {
        Log.e(tag, message)
    }

    override fun i(tag: String, message: String) {
        Log.i(tag, message)
    }
}
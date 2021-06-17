package com.example.something

import android.app.Application

class App :Application() {

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun apiKey(): String

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }

        lateinit var key : String
        private set
    }

    override fun onCreate() {
        super.onCreate()
        key = apiKey()
    }


}
package ru.zxtole.leetcode

import android.app.Application
import ru.zxtole.leetcode.BuildConfig
import timber.log.Timber.*
import timber.log.Timber.Forest.plant


class LeetcodeApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            plant(DebugTree())
        }
    }

}
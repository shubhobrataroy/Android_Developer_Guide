package com.shubhobrata.roy.androiddeveloperguide

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shubhobrata.roy.androiddeveloperguide.data.AndroidInfoRepositoryImpl

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*


@RunWith(AndroidJUnit4::class)
class RepoImplTest {

    private val LOGTAG = "RepoImplTest"

    @Test
    fun testAllAndroidVersionFetch() {

        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val androidInfoRepositoryImpl = AndroidInfoRepositoryImpl(appContext)

        val allAndroidVersions = androidInfoRepositoryImpl.getAllAndroidVersions()

        if(allAndroidVersions.isEmpty())
            fail("Android version cannot be empty ")
        allAndroidVersions.forEach { Log.d(LOGTAG,"${it.first} ${it.second}") }
    }
}
package com.shubhobrata.roy.androiddeveloperguide.data

import android.content.Context
import com.shubhobrata.roy.androiddeveloperguide.domain.repository.AndroidInfoRepository

class AndroidInfoRepositoryImpl(context: Context) : AndroidInfoRepository {
    override fun getAllAndroidVersions(): List<Pair<String, Int>> {
        TODO("Not yet implemented")
    }

    override fun getLatestAndroidVersion(): Pair<String, Int> {
        TODO("Not yet implemented")
    }

}
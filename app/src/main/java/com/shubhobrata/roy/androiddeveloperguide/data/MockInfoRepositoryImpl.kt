package com.shubhobrata.roy.androiddeveloperguide.data

import com.shubhobrata.roy.androiddeveloperguide.domain.repository.AndroidInfoRepository

class MockInfoRepositoryImpl : AndroidInfoRepository {
    override fun getAllAndroidVersions(): List<Pair<String, Int>> {
        return listOf("Pie" to 29, "Oreo" to 28)
    }

    override fun getLatestAndroidVersion(): Pair<String, Int> = "Pie" to 29
    override fun getNameByVersionCode(versionCode: Int): String {
        return ""
    }


}
package com.shubhobrata.roy.androiddeveloperguide.domain.repository

interface AndroidInfoRepository {

    fun getAllAndroidVersions(): List<Pair<String,Int>>

    fun getLatestAndroidVersion() : Pair<String, Int>

}
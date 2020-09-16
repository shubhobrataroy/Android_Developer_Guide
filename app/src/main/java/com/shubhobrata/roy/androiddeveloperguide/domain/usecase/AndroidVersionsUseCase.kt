package com.shubhobrata.roy.androiddeveloperguide.domain.usecase

import com.shubhobrata.roy.androiddeveloperguide.domain.models.AndroidVersionInfo
import com.shubhobrata.roy.androiddeveloperguide.domain.repository.AndroidInfoRepository
import javax.inject.Inject


class AndroidVersionsUseCase @Inject constructor() {

    @Inject
    lateinit var androidVersionRepository: AndroidInfoRepository


    fun getCurrentAndroidVersion() =  androidVersionRepository.getLatestAndroidVersion().run {
        AndroidVersionInfo(first,second)
    }

    fun getAllAndroidVersions() = androidVersionRepository.getAllAndroidVersions().map {
        AndroidVersionInfo(it.first,it.second)
    }

}
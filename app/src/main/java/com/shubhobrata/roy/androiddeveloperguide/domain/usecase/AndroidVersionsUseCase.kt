package com.shubhobrata.roy.androiddeveloperguide.domain.usecase

import com.shubhobrata.roy.androiddeveloperguide.domain.repository.AndroidInfoRepository
import javax.inject.Inject


class AndroidVersionsUseCase @Inject constructor() {

    @Inject
    lateinit var androidVersionRepository: AndroidInfoRepository


    suspend fun getCurrentAndroidVersionName() =
        androidVersionRepository.getLatestAndroidVersion().first


    suspend fun getCurrentAndroidVersionCode() =
        androidVersionRepository.getLatestAndroidVersion().second
}
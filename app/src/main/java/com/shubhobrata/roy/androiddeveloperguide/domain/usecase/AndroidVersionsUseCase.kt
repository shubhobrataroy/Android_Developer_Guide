package com.shubhobrata.roy.androiddeveloperguide.domain.usecase

import com.shubhobrata.roy.androiddeveloperguide.data.MockInfoRepositoryImpl
import com.shubhobrata.roy.androiddeveloperguide.domain.repository.AndroidInfoRepository

class AndroidVersionsUseCase {
    //TODO We will implement DI soon
    private val androidVersionRepository by lazy { MockInfoRepositoryImpl() as AndroidInfoRepository }


    suspend fun getCurrentAndroidVersionName() =
        androidVersionRepository.getLatestAndroidVersion().first


    suspend fun getCurrentAndroidVersionCode() =
        androidVersionRepository.getLatestAndroidVersion().second
}
package com.shubhobrata.roy.androiddeveloperguide.di

import android.content.Context
import com.shubhobrata.roy.androiddeveloperguide.data.AndroidInfoRepositoryImpl
import com.shubhobrata.roy.androiddeveloperguide.data.MockInfoRepositoryImpl
import com.shubhobrata.roy.androiddeveloperguide.domain.repository.AndroidInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class Domain {

    @Singleton
    @Provides
    fun provideAndroidInfoRepo(@ApplicationContext context: Context): AndroidInfoRepository =
//        AndroidInfoRepositoryImpl(context)
        AndroidInfoRepositoryImpl(context)
}
package com.shubhobrata.roy.androiddeveloperguide.presenter.viewmodel

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhobrata.roy.androiddeveloperguide.domain.models.AndroidVersionInfo
import com.shubhobrata.roy.androiddeveloperguide.domain.usecase.AndroidVersionsUseCase
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AndroidVersionsViewModel @ViewModelInject constructor(
    @ApplicationContext applicationContext: Context,
    val androidVersionsUseCase: AndroidVersionsUseCase
) : ViewModel() {


    val currentOSVersionCode = MutableLiveData<Int>()
    val currentOSName = MutableLiveData<String>()
    val allAndroidVersions = MutableLiveData<List<AndroidVersionInfo>>()



    fun getLatestAndroidVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            val (name,code) = androidVersionsUseCase.getCurrentAndroidVersion()
            currentOSName.postValue(name)
            currentOSVersionCode.postValue(code)
        }
    }

    fun fetchAllAndroidVersions()
    {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

}
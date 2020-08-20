package com.shubhobrata.roy.androiddeveloperguide.presenter.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shubhobrata.roy.androiddeveloperguide.domain.usecase.AndroidVersionsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AndroidVersionsViewModel(private val app: Application) : AndroidViewModel(app) {

    private val androidVersionsUseCase by lazy { AndroidVersionsUseCase() }


    val currentOSVersionCode = MutableLiveData<Int>()
    val currentOSName = MutableLiveData<String>()


    fun getLatestAndroidVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            val name = androidVersionsUseCase.getCurrentAndroidVersionName()
            val code = androidVersionsUseCase.getCurrentAndroidVersionCode()
            currentOSName.postValue(name)
            currentOSVersionCode.postValue(code)
        }
    }

}
package com.shubhobrata.roy.androiddeveloperguide.presenter.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhobrata.roy.androiddeveloperguide.domain.usecase.AndroidVersionsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AndroidVersionsViewModel @ViewModelInject constructor(
    private val androidVersionsUseCase: AndroidVersionsUseCase
) : ViewModel() {


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
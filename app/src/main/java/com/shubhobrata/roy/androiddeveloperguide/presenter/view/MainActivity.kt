package com.shubhobrata.roy.androiddeveloperguide.presenter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.shubhobrata.roy.androiddeveloperguide.R
import com.shubhobrata.roy.androiddeveloperguide.presenter.viewmodel.AndroidVersionsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val viewModelModel by lazy { ViewModelProvider(this)[AndroidVersionsViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUi()
        initViewModel()
        initData()
    }

    private fun initData() {
        viewModelModel.getLatestAndroidVersion()
    }

    private fun initViewModel(){
        viewModelModel.currentOSName.observe(this, Observer {
            tv_os_name.text= it?:""

        })

        viewModelModel.currentOSVersionCode.observe(this, Observer {
            tv_os_version.text= it?.toString()?:""
        })


    }

    private fun initUi()
    {

    }
}
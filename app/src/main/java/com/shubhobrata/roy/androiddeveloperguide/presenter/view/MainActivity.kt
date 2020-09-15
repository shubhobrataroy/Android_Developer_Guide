package com.shubhobrata.roy.androiddeveloperguide.presenter.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.shubhobrata.roy.androiddeveloperguide.R
import com.shubhobrata.roy.androiddeveloperguide.presenter.viewmodel.AndroidVersionsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModelModel: AndroidVersionsViewModel by viewModels()

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

    private fun initUi() {

    }
}
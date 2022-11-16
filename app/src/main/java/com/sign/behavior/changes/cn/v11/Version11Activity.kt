package com.sign.behavior.changes.cn.v11

import android.Manifest
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sign.behavior.changes.cn.databinding.ActivityVersion11Binding

class Version11Activity : AppCompatActivity() {

    private lateinit var mBinding: ActivityVersion11Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityVersion11Binding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setSupportActionBar(mBinding.toolbar)

        // 自定义toast
        customToastBackground()

        // 后台位置权限
        foregroundAndBackgroundLocationPermission()

        // 软件包可见性
        getInstalledPackages()
    }

    private fun getInstalledPackages() {
        mBinding.btnInstalledPackages.setOnClickListener {
            val pm = this.packageManager
            val listApplications: List<ApplicationInfo> = pm.getInstalledApplications(PackageManager.GET_META_DATA)
            val strBuilder = StringBuilder()
            for (app in listApplications) {
                strBuilder.append(app.packageName + "\n\n")
            }
            mBinding.tvInstalledPackage.text = strBuilder.toString()
        }
    }

    private fun foregroundAndBackgroundLocationPermission() {
        // 同时请求前台+后台定位权限
        mBinding.btnForegroundAndBackground.setOnClickListener {
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION),
                100)
        }
        // 请求前台定位权限
        mBinding.btnForeground.setOnClickListener {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), 100)
        }// 请求后台定位权限
        mBinding.btnBackground.setOnClickListener {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION), 100)
        }
    }

    private fun customToastBackground() {
        mBinding.root.postDelayed({
            val toast = Toast(this@Version11Activity)
            toast.view = TextView(this@Version11Activity).apply {
                text = "i am custom view Toast"
            }
            toast.duration = Toast.LENGTH_LONG
            toast.show()
        }, 3000)
    }
}
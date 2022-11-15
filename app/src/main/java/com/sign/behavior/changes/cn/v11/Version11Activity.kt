package com.sign.behavior.changes.cn.v11

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
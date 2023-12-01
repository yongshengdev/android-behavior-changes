package com.sign.behavior.changes.cn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import com.sign.behavior.changes.cn.databinding.ActivityMainBinding
import com.sign.behavior.changes.cn.v11.Version11Activity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.btn11.setOnClickListener {
            startActivity(Intent(this@MainActivity, Version11Activity::class.java))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.d("MainActivity", "===============onBackPressed===============")
    }

    override fun finish() {
        super.finish()
        Log.d("MainActivity", "===============finish===============")
    }
}
package com.example.naviappsample

import android.content.Intent
import android.databinding.DataBindingUtil
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.naviappsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.searchButton.setOnClickListener {
            startActivity(Intent().apply {
                action = Intent.ACTION_VIEW
                setClassName("com.google.android.apps.maps", "com.google.android.maps.driveabout.app.NavigationActivity")
                data = Uri.parse("google.navigation:///?q=${binding.address.text}")
            })
        }
    }
}

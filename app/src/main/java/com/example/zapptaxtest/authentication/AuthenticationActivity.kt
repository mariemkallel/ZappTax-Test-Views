package com.example.zapptaxtest.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zapptaxtest.R
import com.example.zapptaxtest.utils.StatusBarUtil

class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        StatusBarUtil.setStatusBarColor(this, R.color.yellow_title_background)

    }

}
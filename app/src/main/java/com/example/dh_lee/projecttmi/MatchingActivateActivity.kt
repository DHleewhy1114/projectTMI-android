package com.example.dh_lee.projecttmi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MatchingActivateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matching_activate)
    }

    override fun onBackPressed() {
        finish()
    }
}

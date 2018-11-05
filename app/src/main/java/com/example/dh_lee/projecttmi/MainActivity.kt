package com.example.dh_lee.projecttmi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
//로그인여부에 따라 다른 activity 실행
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val intent = Intent(this, ViewContainer::class.java)
        //val intent = Intent(this,SetActivityActivity::class.java)
        //val intent = Intent(this, WriteTimelineActivity::class.java)
        val intent = Intent(this, DailyMeal::class.java)
        startActivity(intent)
    }
}

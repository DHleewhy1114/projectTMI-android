package com.example.dh_lee.projecttmi

import android.app.Application
import android.content.Context
import android.util.DisplayMetrics
import android.view.Display
import androidx.appcompat.app.AppCompatActivity


class getDeviceSize(activity:Context){
    val display:DisplayMetrics=activity.resources.displayMetrics
    public fun returnwidth(): Int {
        return display.widthPixels
    }
    public fun returnheight(): Int {
        return display.heightPixels
    }
}
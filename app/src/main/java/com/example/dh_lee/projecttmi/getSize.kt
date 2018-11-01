package com.example.dh_lee.projecttmi

import android.app.Application
import android.content.Context
import android.util.DisplayMetrics
import android.util.Log
import android.view.Display
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class getDeviceSize(activity:Context) {
    val display: DisplayMetrics = activity.resources.displayMetrics
    public fun returnwidth(): Int {
        return display.widthPixels
    }

    public fun returnheight(): Int {
        return display.heightPixels
    }

    public fun substractSize(view2: View, view1: View) {
        val headerHeight = view1.layoutParams.height
        //val headerHeight=view1
        //Log.e("vuew1",view1.layoutParams.height.toString())
        view2.layoutParams.height = this.returnheight() - headerHeight
        Log.e("vuew2",view2.layoutParams.height.toString())
        val lp = view2.getLayoutParams() as ConstraintLayout.LayoutParams
        lp.height = lp.height - headerHeight
        view2.setLayoutParams(lp)
        Log.e("changed view2",view2.layoutParams.height.toString())

    }
}
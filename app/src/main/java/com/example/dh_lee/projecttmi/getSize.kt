package com.example.dh_lee.projecttmi

import android.app.Application
import android.content.Context
import android.util.DisplayMetrics
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
        view2.layoutParams.height = this.returnheight() - headerHeight
        val lp = view2.getLayoutParams() as ConstraintLayout.LayoutParams
        lp.height = lp.height - headerHeight
        view2.setLayoutParams(lp)

    }
}
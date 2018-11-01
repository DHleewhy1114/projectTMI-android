package com.example.dh_lee.projecttmi

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.viewpager.widget.ViewPager

class ContainerViewPager:ViewPager{
    private var isPagingEnabled = true

    constructor(context: Context): super(context){}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var height:Int = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            child.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
            val h = child.measuredHeight
            if (h > height) height = h
        }

        val heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }
    override fun onTouchEvent(event:MotionEvent):Boolean {
        Log.e("ontouch",super.onTouchEvent(event).toString())
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    override fun onInterceptTouchEvent(event:MotionEvent):Boolean {
        Log.e("onintercept",super.onInterceptTouchEvent(event).toString())
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }

   fun setPagingEnabled(b:Boolean) {
        this.isPagingEnabled = b;
    }
}


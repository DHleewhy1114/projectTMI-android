package com.example.dh_lee.projecttmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MyRecordActivity : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inf_view = inflater.inflate(R.layout.activity_my_record, container, false)
        return inf_view

    }
}

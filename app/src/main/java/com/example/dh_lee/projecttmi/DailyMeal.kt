package com.example.dh_lee.projecttmi

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.record_title.*
import kotlinx.android.synthetic.main.record_title.view.*
import java.util.zip.Inflater

class DailyMeal : Fragment() {
    //클릭시 동적인 확장을 위해 fragment로 변경할거
    //https://developer.android.com/guide/components/fragments?hl=ko
    lateinit var morningList:List<String>
    lateinit var morning:ConstraintLayout//include id
    lateinit var morningRecycler:RecyclerView // recyclerview in include
    val lists:ArrayList<MealListResponseData> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inf_view=inflater.inflate(R.layout.activity_daily_meal, container, false)
        val context = inf_view.context
        val linearlayout= LinearLayoutManager(context)
        lists.add(MealListResponseData("1","밥"))
        inf_view.record_title.text="식사목록"
        morning=inf_view.findViewById(R.id.daily_morning)
        morningRecycler=morning.findViewById(R.id.recorded_meal_recycle)
        morningRecycler.layoutManager=linearlayout
        morningRecycler.adapter=MealAdapter(lists,context)
        return inf_view
    }
}

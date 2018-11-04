package com.example.dh_lee.projecttmi

import android.content.Context
import android.content.res.Resources
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.example.dh_lee.projecttmi.InfiniteScrollListener
import com.google.android.material.button.MaterialButton
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getSystemService
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


class TimelineActivity : Fragment() {
    lateinit var recycle:RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var recy:RecyclerView
    val maxItemsPerRequest:Int=5
    val lists:ArrayList<TimelineResponseData> = ArrayList()
    val list=TimelineResponseData("1","이현호","머리가 아프다 ","10월 24일","true")
    var lastVisibleItemPosition:Int=0
    //lateinit var replyBlock:View
    //lateinit var addedReply:View
    private lateinit var scrollListener:RecyclerView.OnScrollListener
    private lateinit var likeIt:MaterialButton
    private lateinit var timelineSwipe:SwipeRefreshLayout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inf_view =inflater.inflate(R.layout.activity_time_line, container, false)
        recy= inf_view.findViewById<RecyclerView>(R.id.timeline_recyclerview)

        timelineSwipe=inf_view.findViewById(R.id.timeline_swipe)
        //replyBlock=inflater.inflate(R.layout.timeline_reply,container,false)
        //addedReply=inf_view.findViewById(R.id.added_reply_block)
        //var likeit=inf_view.findViewById<MaterialButton>(R.id.like_it)
        val lastVisibleItemPosition:Int=1
        lists.add(list)
        lists.add(list)
        lists.add(list)
        lists.add(list)
        lists.add(list)
        lists.add(list)
        lists.add(list)
        lists.add(list)
        lists.add(list)
        lists.add(list)
        lists.add(list)
        lists.add(list)
        val context = inf_view.context
        val linearlayout=LinearLayoutManager(context)
        //likeit.setBackgroundColor(resources.getColor(R.color.material_blue_grey_800, context.theme))
        recy.layoutManager = linearlayout
        recy.adapter=TimelineAdapter(lists,context)
        recy.addOnScrollListener(InfiniteScrollListener({ Log.e("timelinescroll","will be more request")},linearlayout))
        return inf_view

    }
    override fun onStart() {
        super.onStart()
        timelineSwipe.setOnRefreshListener(object: SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                recy.adapter=TimelineAdapter(lists,this@TimelineActivity.context!!)
                timelineSwipe.isRefreshing = false
            }

        })

    }
    private fun addReple(){
        val lparams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT)

            //addedReply.layoutParams=
              //  this.addedReply.addView()

      }
}

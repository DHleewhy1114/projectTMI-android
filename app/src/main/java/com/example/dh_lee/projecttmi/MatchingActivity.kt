package com.example.dh_lee.projecttmi

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.activity_matching.*

class MatchingActivity : Fragment(){
    val lists:ArrayList<MatchingResponseData> = ArrayList()
    lateinit var matchingSwipe:SwipeRefreshLayout
    lateinit var recy:RecyclerView

    val list=MatchingResponseData("1","함께 취업해요","1","/10","서울시 둔촌동","2018.10.24")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inf_view =inflater.inflate(R.layout.activity_matching, container, false)
        recy= inf_view.findViewById<RecyclerView>(R.id.match_recyclerview)
        matchingSwipe=inf_view.findViewById(R.id.matching_swipe)
        val context = inf_view.context
        addResponse()
        val linearlayout=LinearLayoutManager(context)
        recy.layoutManager = linearlayout
        recy.adapter=MatchingAdapter(lists,context)
        recy.addOnScrollListener(InfiniteScrollListener({ Log.e("matchingscroll","will be more request")},linearlayout))//무한 스크롤을 위한 추가
        return inf_view
    }
    private fun makeRecyclerview(recycle: RecyclerView){

    }
    private fun addResponse(){
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
    }

    override fun onStart() {
        super.onStart()
        matchingSwipe.setOnRefreshListener(object:SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                recy.adapter=MatchingAdapter(lists,this@MatchingActivity.context!!)
                matchingSwipe.isRefreshing = false
            }

        })

    }
}

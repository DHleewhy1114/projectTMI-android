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
        recy.layoutManager = linearlayout
        recy.adapter=MatchingAdapter(lists,context)


        recy.addOnScrollListener(InfiniteScrollListener({ Log.e("matchingscroll","will be more request")},linearlayout))
        return inf_view
    }
    private fun makeRecyclerview(recycle: RecyclerView){

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

/*
*
    private fun startActByClick(getintent:AppCompatActivity){
        val intent =Intent(this,getintent::class.java)
        startActivity(intent)
    }
    private fun toQuestionAct(item : DoctorData) {
        val intent =Intent(this,QuestionActivity::class.java)
        intent.putExtra(DOCTOR_ID,item.doctor_id)
        startActivity(intent)
    }
    private fun requestGraphql(recycle:RecyclerView,id:String){
         apolloclient.getMydoctorsQueryCall(id).enqueue(
                object:ApolloCall.Callback<MydoctorsQuery.Data>(){
                    override fun onFailure(e: ApolloException) {
                        Log.e("errormessage",e.message.toString())
                    }
                    override fun onResponse(response: Response<MydoctorsQuery.Data>) {
                        Log.e("responsemessage", response.data()!!.mydoctors().toString())
                        for(item in response.data()!!.mydoctors()!!.iterator()){
                            Log.e("logfor",item.doctorName().toString())
                            lists.add(DoctorData(item.doctorName().toString(),item.doctorCode().toString(),item.id()))
                            Log.e("lists",lists.toString())


                        }
                        runOnUiThread {
                            recycle.swapAdapter(RelationshipAdapter(lists, this@RelationshipActivity, { item: DoctorData -> toQuestionAct(item) }), true)
                            //직접 ui를 건드리지말고 runOnUiThread사용
                            // 데이터가 변했음을 swapadapter에 전달
                        }
                    }
                }

        )
    }
    private fun makeRecyclerview(recycle:RecyclerView){
        recycle.layoutManager = LinearLayoutManager(this)
        recycle.layoutManager = GridLayoutManager(this, 2)
        recycle.adapter = RelationshipAdapter(lists, this,{ item:DoctorData -> toQuestionAct(item) })
    }
* */
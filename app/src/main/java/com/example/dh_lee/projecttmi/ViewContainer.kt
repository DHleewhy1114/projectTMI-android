package com.example.dh_lee.projecttmi

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Point
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TabHost
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_view_container.*
import java.security.cert.PolicyNode


class ViewContainer : AppCompatActivity() {
    //private lateinit var mpagerAdapterr: mPagerAdapter
    private val tabIcons = intArrayOf(R.drawable.icon, R.drawable.noun_timeline, R.drawable.baseline_people_outline_black_18dp)
    lateinit var viewPager:ViewPager
    lateinit var viewContainerHeader:ConstraintLayout
    lateinit var chipGroup:ChipGroup
    lateinit var fab:FloatingActionButton
    lateinit var hashtag:View
    lateinit var addhash:MaterialButton
    lateinit var tabs:TabLayout
    private var isClose=false
    //private val primarycolor= ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null);
    //private val whitecolor= ResourcesCompat.getColor(getResources(), R.color.colorWhite, null);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_container)
        viewContainerHeader=findViewById(R.id.view_container_header)
        tabs=findViewById<TabLayout>(R.id.tabs)
        viewPager=findViewById(R.id.viewPager)
        viewPager.adapter=mPagerAdapter(supportFragmentManager)
        tabs.setupWithViewPager(viewPager,true)
        setuptabIcon(tabs)
        val primarycolor= ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null);
        val whitecolor= ResourcesCompat.getColor(getResources(), R.color.colorWhite, null);
        tabs.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.getIcon()!!.setColorFilter(primarycolor, PorterDuff.Mode.SRC_IN); //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                tab.getIcon()!!.setColorFilter(whitecolor, PorterDuff.Mode.SRC_IN); //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.getIcon()!!.setColorFilter(whitecolor, PorterDuff.Mode.SRC_IN);

            }
        })
        fab=findViewById(R.id.fab)
        fab.setOnClickListener{
            when(tabs.selectedTabPosition){
                0->{
                    setintent(WriteTimelineActivity())
                }
                1->{
                    setintent(SetActivityActivity())
                }
                2->{
                    setintent(WriteTimelineActivity())//추후에 작성activity
                }
                else->{
                    print("")
                }
            }
        }
    }
    fun setintent(app:AppCompatActivity){
        val intent = Intent(this,app::class.java)
        startActivity(intent)

    }
    fun setuptabIcon(tabs:TabLayout){
        tabs.getTabAt(0)!!.setIcon(tabIcons[1])
        tabs.getTabAt(1)!!.setIcon(tabIcons[2])
        tabs.getTabAt(2)!!.setIcon(tabIcons[0])
    }

    override fun onBackPressed() {
        if(isClose==false) {
            Toast.makeText(this,"한번더 뒤로 버튼을 누르시면 종료합니다",Toast.LENGTH_LONG).show()
            isClose=true
        }
        else{
            super.onBackPressed()
        }
    }
}


class mPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = 3

    override fun getItem(i: Int): Fragment {
        when (i) {
            0 -> return TimelineActivity()
            1 -> return MatchingActivity()
            2 -> return DailyRecord()
            else -> {
                return MainTabFragment1()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return "타임라인"
            1 -> return "매칭"
            2 -> return "내 기록"
            else -> {
                return ""
            }
        }
    }
}
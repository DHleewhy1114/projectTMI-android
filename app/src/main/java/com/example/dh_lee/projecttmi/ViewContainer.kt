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
        /*fab=findViewById(R.id.fab)
        fab.setOnClickListener{
            when(tabs.selectedTabPosition){
                0->{
                    setintent(DailyRecord())
                }
                1->{

                   setintent(WriteTimelineActivity())

                }
                2->{
                    setintent(SetActivityActivity())
                }
                else->{
                    print("")
                }
            }
        }*/
        //chipGroup=findViewById(R.id.chiplist)
        //val con =layoutInflater.inflate(R.layout.activity_matching,null,false)
        //val context=con.context
        //makeChip(context,findViewById(R.id.chiplist),"dsds")

    }

    override fun onStart() {
        super.onStart()
        //val a =getDeviceSize(this)
        //a.substractSizeWithView(viewPager,viewContainerHeader)
    }
    fun setintent(app:AppCompatActivity){
        val intent = Intent(this,app::class.java)
        startActivity(intent)

    }
    fun setuptabIcon(tabs:TabLayout){
        tabs.getTabAt(0)!!.setIcon(tabIcons[0])
        tabs.getTabAt(1)!!.setIcon(tabIcons[1])
        tabs.getTabAt(2)!!.setIcon(tabIcons[2])
    }
    fun makeChip(context:Context,chipGroup: ChipGroup,str:String){
        val chip = Chip(context)
        chip.text=str
        chip.isCloseIconVisible=true
        chipGroup.addView(chip as View)
        chip.setOnCloseIconClickListener{
            chipGroup.removeView(chip as View)
        }

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
            0 -> return MyRecordActivity()
            1 -> return TimelineActivity()
            2 -> return MatchingActivity()
            else -> {
                return MainTabFragment1()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return "내 기록"
            1 -> return "타임라인"
            2 -> return "매칭"
            else -> {
                return ""
            }
        }
    }
}

/*
private const val ARG_OBJECT = "object"

// Instances of this class are fragments representing a single
// object in our collection.
class mObjectFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // The last two arguments ensure LayoutParams are inflated properly.
        val rootView: View = inflater.inflate(
                R.layout.tab_fragment_1, container, false)
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            val textView: TextView = rootView.findViewById(android.R.id.text1)
            textView.text = getInt(ARG_OBJECT).toString()
        }
        return rootView
    }
}*/
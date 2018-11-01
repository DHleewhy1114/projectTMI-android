package com.example.dh_lee.projecttmi

import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TabHost
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.security.cert.PolicyNode


class ViewContainer : AppCompatActivity() {
    //private lateinit var mpagerAdapterr: mPagerAdapter
    private val tabIcons = intArrayOf(R.drawable.icon, R.drawable.ic_arrow_back, R.drawable.ic_arrow_back)
    lateinit var viewPager:ViewPager
    lateinit var chipGroup:ChipGroup
    lateinit var fab:FloatingActionButton
    lateinit var hashtag:View
    lateinit var addhash:MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_container)
        val tabs:TabLayout=findViewById<TabLayout>(R.id.tabs)
        viewPager=findViewById(R.id.viewPager)
        viewPager.adapter=mPagerAdapter(supportFragmentManager)
        tabs.setupWithViewPager(viewPager,true)
        setuptabIcon(tabs)

        fab=findViewById(R.id.fab)
        fab.setOnClickListener{
            when(tabs.selectedTabPosition){
                0->{
                 ""
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
        }
        //chipGroup=findViewById(R.id.chiplist)
        //val con =layoutInflater.inflate(R.layout.activity_matching,null,false)
        //val context=con.context
        //makeChip(context,findViewById(R.id.chiplist),"dsds")

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
            0 -> return "My Record"
            1 -> return "Time Line"
            2 -> return "Matching"
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
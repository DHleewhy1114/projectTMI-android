package com.example.dh_lee.projecttmi

import android.os.Bundle
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



class ViewContainer : AppCompatActivity() {
    //private lateinit var mpagerAdapterr: mPagerAdapter
    lateinit var viewPager:ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_container)
        //mpagerAdapterr = mPagerAdapter(supportFragmentManager)
        //mviewPager = findViewById(R.id.viewPager)

        val tabs:TabLayout=findViewById<TabLayout>(R.id.tabs)
        viewPager=findViewById(R.id.viewPager)
        viewPager.adapter=mPagerAdapter(supportFragmentManager)
        tabs.setupWithViewPager(viewPager,true)
    }
}

class mPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int  = 3

    override fun getItem(i: Int): Fragment {
        when(i){
            0->return MainTabFragment1()
            1->return MainTabFragment2()
            2->return MainTabFragment3()
            else->{
                return MainTabFragment1()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "tab" + (position + 1)
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
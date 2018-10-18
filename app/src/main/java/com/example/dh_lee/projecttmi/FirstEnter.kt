package com.example.dh_lee.projecttmi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.FragmentStatePagerAdapter



class FirstEnter : AppCompatActivity() {
    private lateinit var mViewPager: ViewPager
    //private lateinit var mPagerAdapter:PagerAdapter
    private lateinit var mTabLayout:TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_enter)
        mViewPager=findViewById(R.id.first_pager)
        //mViewPager.adapter=mPagerAdapter()
        //mViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mTabLayout))
        mTabLayout=findViewById(R.id.first_tab_layout)
        mTabLayout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(mViewPager))
        val adapter = PagerAdapter(supportFragmentManager,mTabLayout.tabCount)
        mViewPager.setAdapter(adapter)
        mViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mTabLayout))
        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        }
    }

class PagerAdapter(fm: FragmentManager, internal var mNumOfTabs: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        when (position) {
            0 -> {
                return TabFragment1()
            }
            1 -> {
                return TabFragment2()
            }

            else -> return null
        }
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }
}

package com.example.dh_lee.projecttmi

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
class DailyRecord : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val inf_view = inflater.inflate(R.layout.activity_daily_record, container, false)

        val fragmentManager = getFragmentManager()
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        val mealFragment = DailyMeal()
        fragmentTransaction.add(R.id.recorded_daily_meal_fragment, mealFragment)
        fragmentTransaction.commit()
        return inf_view
    }
}


/*
class DailyRecord : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_record)

        val fragmentManager =supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val mealFragment = DailyMeal()
        fragmentTransaction.add(R.id.recorded_daily_meal_fragment,mealFragment)
        fragmentTransaction.commit()

        /*val mealFragment = DailyMeal();

        // In case this activity was started with special instructions from an
        // Intent, pass the Intent's extras to the fragment as arguments
        //val meal_intent= Intent(this,mealFragment.class.java);
        //mealFragment.arguments = getIntent().getExtras();

        getSupportFragmentManager()
        .beginTransaction()
                .add(R.id.recorded_daily_drug_fragment, mealFragment).commit()
    */}
}
*/

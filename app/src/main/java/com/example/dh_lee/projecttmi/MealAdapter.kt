package com.example.dh_lee.projecttmi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.matching_unit.view.*
import kotlinx.android.synthetic.main.meal.view.*
import java.util.*

class MealAdapter(val mealData:List<MealListResponseData>, val context: Context): RecyclerView.Adapter<MealAdapter.MealViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder{
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.meal, parent, false)
        return MealViewHolder(view)

    }
    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        (holder as MealViewHolder).bind(mealData[position])
    }

    override fun getItemCount(): Int {
        return mealData.size
    }

    class MealViewHolder(view:View):RecyclerView.ViewHolder(view){
        fun bind(item:MealListResponseData){
            itemView.meal.text=item.item
        }
    }
}


package com.example.dh_lee.projecttmi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.matching_unit.view.*

/*data class MatchingResponseData(
        override val id:String, val participant_number:String,val place:String,val date:String):HTTPResponseData*/
class MatchingAdapter(val matchingData:List<MatchingResponseData>, val context: Context): RecyclerView.Adapter<MatchingAdapter.MatchingViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchingViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.matching_unit, parent,false)
        return MatchingViewHolder(view)
    }
    override fun onBindViewHolder(holder: MatchingViewHolder, position: Int) {
        (holder as MatchingViewHolder).bind(matchingData[position])
    }

    override fun getItemCount(): Int {
        return matchingData.size
    }



    class MatchingViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(item:MatchingResponseData){
            itemView.matching_participant_number.text=item.participant_number
            itemView.matching_date.text=item.date
            itemView.matching_place.text=item.place
        }
    }

}
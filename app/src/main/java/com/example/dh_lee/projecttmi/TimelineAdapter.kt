package com.example.dh_lee.projecttmi

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.timeline_unit.view.*//build.gradle에 implementation 'androidx.core:core-ktx:1.0.0'가 존재해야함


class TimelineAdapter(val timelineData:List<TimelineResponseData>, val context: Context ):RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.timeline_unit, parent,false)
        return TimelineViewHolder(view)
    }
    override fun onBindViewHolder(holder: TimelineViewHolder, position: Int) {
        (holder as TimelineViewHolder).bind(timelineData[position])
        if(timelineData[position].islikeit=="true"){
            //holder.iconview.setBackgroundColor(getColor(context,R.color.colorRed))
        }
    }

    override fun getItemCount(): Int {
       return timelineData.size
    }



    class TimelineViewHolder(view:View):RecyclerView.ViewHolder(view){
        //val iconview=itemView.like_it
        fun bind(item:TimelineResponseData){
            itemView.timelne_author.text=item.author
            itemView.timeline_created.text=item.created
            //itemView.timeline_contents.text=item.contents
        }
    }

}
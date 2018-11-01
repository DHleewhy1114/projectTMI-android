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
            holder.iconview.setBackgroundColor(getColor(context,R.color.colorRed))
        }
    }

    override fun getItemCount(): Int {
       return timelineData.size
    }



    class TimelineViewHolder(view:View):RecyclerView.ViewHolder(view){
        val iconview=itemView.like_it
        fun bind(item:TimelineResponseData){
            itemView.author.text=item.author
            itemView.created.text=item.created
            itemView.timeline_contents.text=item.contents
        }
    }

}
/*
* android:id="@+id/author"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />
            <TextView
                android:id="@+id/created"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />
        </LinearLayout>
    </LinearLayout>
        <TextView
            android:text="사진컨텐츠"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
        <TextView
            android:id="@+id/timeline_contents"*/
/*
class HospitalAdapter(val items: List<HospitalData>, val context: Context,val clickListener: (HospitalData) -> Unit): RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):HospitalViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.hospitalcomponent, parent,false)
        return HospitalViewHolder(view)
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        (holder as HospitalViewHolder).bind(items[position],clickListener)
    }

    class HospitalViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(item: HospitalData, clickListener: (HospitalData) -> Unit){
            itemView.hospital_name.text = item.hospital_name
            itemView.hospital_info.text = item.hospital_info
            itemView.setOnClickListener{ clickListener(item)}
        }
    }
}
        */
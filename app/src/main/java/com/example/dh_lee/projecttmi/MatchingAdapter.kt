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
/*
* <?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <com.google.android.material.card.MaterialCardView
        android:id="@+id/matching_card"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">
            <LinearLayout
                android:layout_height="wrap_content"
                android:layout_width="wrap_content"
                android:orientation="horizontal">
                <TextView
                    android:layout_height="wrap_content"
                    android:layout_width="wrap_content" />
                <com.google.android.material.button.MaterialButton
                    android:layout_height="wrap_content"
                    android:layout_width="wrap_content"
                    android:text="함께하기"/>

            </LinearLayout>
            <LinearLayout
                android:layout_height="wrap_content"
                android:layout_width="match_parent"
                android:orientation="horizontal">
                <TextView
                    android:id="@+id/matching_participant"
                    android:layout_height="wrap_content"
                    android:layout_width="wrap_content" />
                <TextView
                    android:id="@+id/matching_date"
                    android:layout_height="wrap_content"
                    android:layout_width="wrap_content" />
                <TextView
                    android:id="@+id/matching_place"
                    android:layout_height="wrap_content"
                    android:layout_width="wrap_content" />
            </LinearLayout>
        </LinearLayout>
    </com.google.android.material.card.MaterialCardView>


</androidx.constraintlayout.widget.ConstraintLayout>*/
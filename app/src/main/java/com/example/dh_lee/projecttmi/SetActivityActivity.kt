package com.example.dh_lee.projecttmi

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import android.view.ViewGroup.LayoutParams.FILL_PARENT
import androidx.constraintlayout.widget.ConstraintLayout


class SetActivityActivity : AppCompatActivity() {
    lateinit var setActivityTitle:TextView
    lateinit var setActivityDate:TextView
    lateinit var setActivityPlace:TextView
    lateinit var setActivityParticipant:TextView
    lateinit var setActivityContents:TextView
    lateinit var header:androidx.appcompat.widget.Toolbar
    lateinit var body:ConstraintLayout
    lateinit var finishButton:MaterialButton
    var deviceHeight:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_activity)
        body=findViewById(R.id.set_activity_body)
        header=findViewById(R.id.set_activity_toolbar)
        setActivityTitle=findViewById(R.id.set_activaity_title_text)
        setActivityDate=findViewById(R.id.set_activity_date_text)
        setActivityContents=findViewById(R.id.set_activity_contents_text)
        setActivityParticipant=findViewById(R.id.set_activity_participant_text)
        setActivityPlace=findViewById(R.id.set_activity_place_text)
        finishButton=findViewById(R.id.set_activity_finish)
        setActivityTitle.text="활동명을 입력해주세요"
        setActivityPlace.text="어디에서 진행하나요?"
        setActivityParticipant.text="몇 명까지 참여 가능한가요?"
        setActivityDate.text="언제 진행하나요?"
        setActivityContents.text="활동 세부 사항을 적어주세요"
        deviceHeight=getDeviceSize(this).returnheight()
        //Log.e("deviceheight",deviceHeight.toString())
        //Log.e("headerheight",header.height.toString())
        body.requestLayout()
        //body.requestLayout()
        //body.layoutParams.height=deviceHeight-header.height
        //Log.e("bodyheight",body.layoutParams.height.toString())


    }

    override fun onStart() {
        super.onStart()
        Log.e("headerHeight", header.layoutParams.height.toString())
        val headerHeight = header.layoutParams.height
        Log.e("before change",body.layoutParams.height.toString())
        body.layoutParams.height = deviceHeight - headerHeight
        Log.e("bodyHeight", body.layoutParams.height.toString())
        val lp = body.getLayoutParams() as ConstraintLayout.LayoutParams
        lp.height = lp.height - headerHeight
        body.setLayoutParams(lp)
        //body.gravity=Gravity.BOTTOM
        //finishButton.gravity=Gravity.END
        // android:layout_gravity="end|bottom"TextView textView=findViewById(R.id.spn);


    }
}

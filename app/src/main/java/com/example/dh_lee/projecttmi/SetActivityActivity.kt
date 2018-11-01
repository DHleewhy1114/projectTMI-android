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
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.adapters.ToolbarBindingAdapter
import kotlinx.android.synthetic.main.activity_set_activity.*
import kotlinx.android.synthetic.main.toolbar.*


class SetActivityActivity : AppCompatActivity() {
    lateinit var setActivityTitle:TextView
    lateinit var setActivityDate:TextView
    lateinit var setActivityPlace:TextView
    lateinit var setActivityParticipant:TextView
    lateinit var setActivityContents:TextView
    lateinit var body:ConstraintLayout
    lateinit var finishButton:MaterialButton
    lateinit var header:ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_activity)
        setIDs()
        setTexts()
        toolbar_title.text="제목들어감"
        /*
        val binding:ToolbarBinding = setContentView(this, R.layout.toolbar)
        val user = com.example.dh_lee.projecttmi.Toolbar("활동 만들기")
        binding.setUser(user)*/

    }

    override fun onStart() {
        super.onStart()
        val a =getDeviceSize(this)
        Log.e("headerhegiht",header.layoutParams.height.toString())
        a.substractSize(body,header)
    }

    private fun setIDs(){
        body=findViewById(R.id.set_activity_body)
        header=findViewById(R.id.set_activity_toolbar)
        setActivityTitle=findViewById(R.id.set_activaity_title_text)
        setActivityDate=findViewById(R.id.set_activity_date_text)
        setActivityContents=findViewById(R.id.set_activity_contents_text)
        setActivityParticipant=findViewById(R.id.set_activity_participant_text)
        setActivityPlace=findViewById(R.id.set_activity_place_text)
        finishButton=findViewById(R.id.set_activity_finish)
    }
    private fun setTexts(){
        setActivityTitle.text="활동명을 입력해주세요"
        setActivityPlace.text="어디에서 진행하나요?"
        setActivityParticipant.text="몇 명까지 참여 가능한가요?"
        setActivityDate.text="언제 진행하나요?"
        setActivityContents.text="활동 세부 사항을 적어주세요"
    }
}
/*package com.example.dh_lee.projecttmi

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


    }

    override fun onStart() {
        super.onStart()
        val a =getDeviceSize(this)
        a.substractSize(body,header)
    }

}

*/

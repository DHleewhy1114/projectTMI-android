package com.example.dh_lee.projecttmi

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.widget.TextView





class WriteTimelineActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onBackPressed() {
        finish()
    }

    lateinit var publicSpinner:Spinner
    lateinit var spinnerText:String
    private var isPublic:Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_timeline)
        publicSpinner = findViewById(R.id.topublic)
        //spinnerText=publicSpinner.selectedItem.toString()
        val adapter:ArrayAdapter<CharSequence> =ArrayAdapter.createFromResource(this, R.array.topublic,
                android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item){
            
        }
        publicSpinner.adapter=adapter
        publicSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItemText = parent.getItemAtPosition(position) as String
                // Notify the selected item text

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        })
    }

}

private fun <T> ArrayAdapter<T>.setDropDownViewResource(simple_spinner_dropdown_item: Int, function: () -> Unit) {

}

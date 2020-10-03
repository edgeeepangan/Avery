package com.example.avery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AddBud : AppCompatActivity() {

    val curStr = findViewById<TextView>(R.id.bal)
    val inStr = findViewById<EditText>(R.id.add_to)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_budget)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Add to Budget"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val addToBal = findViewById<Button>(R.id.confirm)
        addToBal.setOnClickListener { addBudget() }
    }

    fun addBudget(){
        val curBal = curStr.toString()
        val inBal = inStr.toString()
        val add = curBal.toDouble() + inBal.toDouble()
        curStr.setText(add.toString())
        val int = Intent(this, MainActivity::class.java)
        val total = int.putExtra("total", curStr.text.toString())
        startActivity(int)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
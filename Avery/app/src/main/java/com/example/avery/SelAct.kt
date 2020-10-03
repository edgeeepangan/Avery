package com.example.avery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_act)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Select Action"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        //add budget
        val add_bud = findViewById<Button>(R.id.add_budget)
        add_bud.setOnClickListener {
            val int = Intent(this,AddBud::class.java)
            startActivity(int)
        }

        //add others
        val add_oth = findViewById<Button>(R.id.add_other)
        add_oth.setOnClickListener {
            val int = Intent(this, AddOth::class.java)
            startActivity(int)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
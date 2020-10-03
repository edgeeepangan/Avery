package com.example.avery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val int = getIntent()
        val grandTotal = findViewById<TextView>(R.id.total)
        val total = int.getStringExtra("total")
        grandTotal.setText(total)

        val exp = findViewById<TextView>(R.id.exp_val)
        val expT = int.getStringExtra("fSub").toInt()+int.getStringExtra("sSub").toInt()+int.getStringExtra("eSub").toInt()+
                int.getStringExtra("hSub").toInt()+int.getStringExtra("enSub").toInt()
        exp.setText(expT.toString())


        val inc = findViewById<TextView>(R.id.inc_val)
        val incT = int.getStringExtra("sAdd").toInt()+int.getStringExtra("pAdd").toInt()+int.getStringExtra("bAdd").toInt()+
                int.getStringExtra("lAdd").toInt()+int.getStringExtra("aAdd").toInt()
        inc.setText(incT.toString())


        val food = findViewById<TextView>(R.id.fod_val)
        val fTotal = (int.getStringExtra("fSub").toDouble() + food.toString().toDouble()).toString()
        food.setText("-" + fTotal)

        val eqp = findViewById<TextView>(R.id.eqp_val)
        val eTotal = (int.getStringExtra("eSub").toDouble() + eqp.toString().toDouble()).toString()
        eqp.setText("-" + eTotal)

        val sal = findViewById<TextView>(R.id.sal_val)
        val sTotal = (int.getStringExtra("sAdd").toDouble() + sal.toString().toDouble()).toString()
        sal.setText("+" + sTotal)

        /*To be implemented: creating different values daily for each expense/income*/

        //Floating button function
        val fab = findViewById<View> (R.id.fab_add)
        fab.setOnClickListener {
            val int = Intent(this,AddOth::class.java)
            startActivity(int)
        }
    }

}
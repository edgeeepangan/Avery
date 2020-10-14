package com.example.avery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val int = getIntent()
        val grandTotal = findViewById<TextView>(R.id.total)
        val total = int.getStringExtra("total")
        grandTotal.setText(total)

        val food = findViewById<TextView>(R.id.fod_val)
        val foodS = food.text.toString()
        val eqp = findViewById<TextView>(R.id.eqp_val)
        val eqpS = eqp.text.toString()
        val sal = findViewById<TextView>(R.id.sal_val)
        val salS = sal.text.toString()


        if (int.getStringExtra("fSub") != null) {
            val fTotal = (int.getStringExtra("fSub")!!.toDouble() + foodS.toDouble()).toString()
            food.setText(fTotal)
        } else if (int.getStringExtra("eSub") != null) {
            val eTotal = (int.getStringExtra("eSub")!!.toDouble() + eqpS.toDouble()).toString()
            eqp.setText(eTotal)
        } else if (int.getStringExtra("sAdd") != null) {
            val sTotal = (int.getStringExtra("sAdd")!!.toDouble() + salS.toDouble()).toString()
            sal.setText(sTotal)
        }
        /*To be implemented: creating different values daily for each expense/income*/

        val exp = findViewById<TextView>(R.id.exp_val)
        val expT = (foodS.toDouble() + eqpS.toDouble()).absoluteValue
        exp.setText(expT.toString())

        val inc = findViewById<TextView>(R.id.exp_val)
        val incT = salS.toDouble().absoluteValue /* to be implemented: add other income*/
        inc.setText(incT.toString())

        //Floating button function
        val fab = findViewById<View> (R.id.fab_add)
        fab.setOnClickListener {
            val int = Intent(this,AddOth::class.java)
            startActivity(int)
        }
    }

}

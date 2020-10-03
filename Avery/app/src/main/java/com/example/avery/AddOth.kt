package com.example.avery

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity


class AddOth : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_act)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Add Expenses/Income"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        //spinner 1
        val addChoices = resources.getStringArray(R.array.add_choice)
        val spin1 = findViewById<Spinner>(R.id.add_spinner)
        val adapter1 = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, addChoices)
        spin1.adapter = adapter1

        //spinner 2
        val expChoices = resources.getStringArray(R.array.exp_choice)
        val incChoices = resources.getStringArray(R.array.inc_choice)
        val spin2 = findViewById<Spinner>(R.id.purpose_spinner)
        val adapter2 = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, expChoices)
        val adapter3 = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, incChoices)
        spin2.adapter = adapter2

        //instantiate other variables
        val inputVal = findViewById<EditText>(R.id.input_amount)
        val confirm = findViewById<Button>(R.id.yes)
        val int = Intent(this, MainActivity::class.java)

        //change contents of spinner 2 based on spinner 1
        spin1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, i: Int, l: Long) {
                val spinnerValue: String = spin1.getSelectedItem().toString()
                    if (spinnerValue == "Expense") {
                        spin2.setAdapter(adapter2)
                    } else {
                        spin2.setAdapter(adapter3)
                    }
                }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }

        //passing of values based on spinner 2
        spin2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, i: Int, l: Long) {
                val spinnerValue: String = spin2.getSelectedItem().toString()
                if (spinnerValue == "Food") {
                    confirm.setOnClickListener {
                        int.putExtra("fSub", inputVal.text.toString())
                        startActivity(int)
                    }
                } else if (spinnerValue == "Shopping") {
                    confirm.setOnClickListener {
                        int.putExtra("sSub", inputVal.text.toString())
                        startActivity(int)
                    }
                } else if (spinnerValue == "Equipment") {
                    confirm.setOnClickListener {
                        int.putExtra("eSub", inputVal.text.toString())
                        startActivity(int)
                    }
                } else if (spinnerValue == "Home Expenses") {
                    confirm.setOnClickListener {
                        int.putExtra("hSub", inputVal.text.toString())
                        startActivity(int)
                    }
                } else if (spinnerValue == "Entertainment") {
                    confirm.setOnClickListener {
                        int.putExtra("enSub", inputVal.text.toString())
                        startActivity(int)
                    }
                } else if (spinnerValue == "Salary") {
                    confirm.setOnClickListener {
                        int.putExtra("sAdd", inputVal.text.toString())
                        startActivity(int)
                    }
                } else if (spinnerValue == "Prize") {
                    confirm.setOnClickListener {
                        int.putExtra("pAdd", inputVal.text.toString())
                        startActivity(int)
                    }
                } else if (spinnerValue == "Bonus") {
                    confirm.setOnClickListener {
                        int.putExtra("bAdd", inputVal.text.toString())
                        startActivity(int)
                    }
                } else if (spinnerValue == "Loan") {
                    confirm.setOnClickListener {
                        int.putExtra("lAdd", inputVal.text.toString())
                        startActivity(int)
                    }
                } else if (spinnerValue == "Allowance") {
                    confirm.setOnClickListener {
                        int.putExtra("aAdd", inputVal.text.toString())
                        startActivity(int)
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
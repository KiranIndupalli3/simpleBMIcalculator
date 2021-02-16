package com.example.simplebmicalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.find_bmi).setOnClickListener {
            showBMI(it)
        }

        findViewById<Button>(R.id.refresh_button).setOnClickListener {
            val weight_num = findViewById<EditText>(R.id.weight_text)
            val height_num = findViewById<EditText>(R.id.height_text)
            val bmi_view = findViewById<TextView>(R.id.result)

            

        }
    }

    private fun showBMI(view: View) {
        val weight_num = findViewById<EditText>(R.id.weight_text).text.toString().toFloat()
        val height_num = findViewById<EditText>(R.id.height_text).text.toString().toFloat()

        val bmi = (weight_num/(height_num*height_num)) * 10000

        val bmi_final = "%.2f".format(bmi)

        val bmi_view = findViewById<TextView>(R.id.result)
        bmi_view.text = bmi_final

        bmi_view.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
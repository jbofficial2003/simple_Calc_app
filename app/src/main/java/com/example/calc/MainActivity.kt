package com.example.calc

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), OnClickListener{


    lateinit var btn_plus : Button
    lateinit var btn_minus : Button
    lateinit var btn_multiply : Button
    lateinit var btn_divide : Button
    lateinit var input_a : EditText
    lateinit var input_b : EditText
    lateinit var answer: TextView
    lateinit var clear : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btn_plus= findViewById(R.id.plus)
        btn_minus= findViewById(R.id.minus)
        btn_multiply= findViewById(R.id.multiply)
        btn_divide= findViewById(R.id.divide)
        input_a= findViewById(R.id.num_a)
        input_b= findViewById(R.id.num_b)
        answer= findViewById(R.id.result)
        clear=findViewById(R.id.AC)

        btn_plus.setOnClickListener(this)
        btn_minus.setOnClickListener(this)
        btn_multiply.setOnClickListener(this)
        btn_divide.setOnClickListener(this)
        clear.setOnClickListener(this)

        }


    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        var num1 = input_a.text.toString().toDoubleOrNull()
        var num2 = input_b.text.toString().toDoubleOrNull()
        var result: Double? = null
        when (v?.id) {
            R.id.plus -> {
                result = if (num1 != null && num2 != null) num1 + num2 else null
            }

            R.id.minus -> {
                result = if (num1 != null && num2 != null) num1 - num2 else null
            }

            R.id.multiply -> {
                result = if (num1 != null && num2 != null) num1 * num2 else null
            }

            R.id.divide -> {
                result = if (num1 != null && num2 != null && num2 != 0.0) num1 / num2 else null
            }

            R.id.AC -> {
                result = 0.0
                input_a.text.clear()
                input_b.text.clear()
            }
        }
        answer.text = "$result"
    }
}
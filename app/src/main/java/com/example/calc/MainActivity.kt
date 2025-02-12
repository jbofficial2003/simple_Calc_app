package com.example.calc

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.os.VibrationEffect
import android.os.Build
import android.os.VibratorManager

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

    lateinit var vibrator: Vibrator


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager = getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        }


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
                vibrate()
                result = if (num1 != null && num2 != null) num1 + num2 else null
            }

            R.id.minus -> {
                vibrate()
                result = if (num1 != null && num2 != null) num1 - num2 else null
            }

            R.id.multiply -> {
                vibrate()
                result = if (num1 != null && num2 != null) num1 * num2 else null
            }

            R.id.divide -> {
                vibrate()
                result = if (num1 != null && num2 != null && num2 != 0.0) num1 / num2 else null
            }

            R.id.AC -> {
                result = 0.0
                input_a.text.clear()
                input_b.text.clear()
                vibrate2()
            }
        }
        answer.text = "$result"
    }
    private fun vibrate() {
        if (vibrator.hasVibrator()) { // Check if device supports vibration
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(15, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                vibrator.vibrate(100) // Deprecated but works on older devices
            }
        }
    }

    private fun vibrate2() {
        if (vibrator.hasVibrator()) { // Check if device supports vibration
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                vibrator.vibrate(100) // Deprecated but works on older devices
            }
        }
    }

}

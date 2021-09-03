package com.example.androidlayoutconstraintsandhelpers

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var num = 0
    lateinit var btn: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.button)
        val btn2 = findViewById<Button>(R.id.button2)
        val btn3 = findViewById<Button>(R.id.button3)

        btn.setOnClickListener {
            num += 1
            btn.text = num.toString()
        }
        btn2.setOnClickListener {
            num = 0
            btn.text = "CLICK ME"
        }
        btn3.setOnClickListener {
            btn3.visibility = View.INVISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("saved_number", btn.text.toString())
        outState.putString("saved_number2", num.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        btn.text = savedInstanceState.getString("saved_number")
        num = savedInstanceState.getString("saved_number2")!!.toInt()
    }
}
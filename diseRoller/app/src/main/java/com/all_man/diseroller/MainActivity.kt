package com.all_man.diseroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
//        val randomInt = Random().nextInt(6) + 1

        val resultText: TextView = findViewById(R.id.result_text)
        if ( resultText.text == "1" || resultText.text == "2" || resultText.text == "3" || resultText.text == "4" || resultText.text == "5" ) {
            resultText.text = (resultText.text.toString().toInt() + 1).toString()
        } else {
            resultText.text = "1"
        }
//        resultText.text = randomInt.toString()

        Toast.makeText(this, "button pushed", Toast.LENGTH_SHORT).show()
    }
}
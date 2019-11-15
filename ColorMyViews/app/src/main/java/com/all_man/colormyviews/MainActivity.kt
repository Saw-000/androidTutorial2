package com.all_man.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val RedButton = findViewById<Button>(R.id.red_button)
        val YellowButton = findViewById<Button>(R.id.yellow_button)
        val GreenButton = findViewById<Button>(R.id.green_button)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText,
                RedButton, YellowButton, GreenButton,
                rootConstraintLayout)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when(view.id) {
            //Touch the text_boxes
            R.id.box_one_text -> view.setBackgroundResource(R.drawable.apple1)
            R.id.box_two_text -> view.setBackgroundResource(R.drawable.apple2)
            R.id.box_three_text -> view.setBackgroundResource(R.drawable.apple3)
            R.id.box_four_text -> view.setBackgroundResource(R.drawable.apple4)
            R.id.box_five_text -> view.setBackgroundResource(R.drawable.apple5)
            // Touch the buttons
            R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)
            // Touch the background
            else -> view.setBackgroundResource(R.drawable.apple_background)
        }
    }
}

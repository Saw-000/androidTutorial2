package com.all_man.diseroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import java.util.*


const val KEY_DICENUMRESOURCE = "diceNumResource_key"
const val KEY_DICENUMRESOURCE2 = "diceNumResource2_key"
class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView

    private var diceNumResource = 0
    private var diceNumResource2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

        if (savedInstanceState != null) {
            diceNumResource = savedInstanceState.getInt("diceNumResource_key", 0)
            diceNumResource2 = savedInstanceState.getInt("diceNumResource2_key", 0)

            diceImage.setImageResource(diceNumResource)
            diceImage2.setImageResource(diceNumResource2)
        }
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        diceNumResource = setImageResource()
        diceNumResource2 = setImageResource()
        diceImage.setImageResource(diceNumResource)
        diceImage2.setImageResource(diceNumResource2)
    }

    private fun setImageResource(): Int {
        val randomInt = Random().nextInt(6) + 1
        val imageResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        return imageResource
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_DICENUMRESOURCE, diceNumResource)
        outState.putInt(KEY_DICENUMRESOURCE2, diceNumResource2)
    }
}

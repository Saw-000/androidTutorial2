package com.all_man.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.all_man.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Ie So")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener{ addNickname(it) }
        binding.nickname.setOnClickListener{ updateNickname() }
    }

    private fun addNickname(view: View) {
        binding.apply {
            myName?.nickname = binding.nicknameEdit.text.toString()
            // data変数の値の変化は、binding Object自体の変化とみなされるらしいから、
            // rebindして新しいデータでUIをrefreshする。
            invalidateAll()
            nickname.visibility = View.VISIBLE
            doneButton.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }



    private fun updateNickname() {
        binding.apply {
            nickname.visibility = View.GONE
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE

            nicknameEdit.requestFocus()
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)
    }
}

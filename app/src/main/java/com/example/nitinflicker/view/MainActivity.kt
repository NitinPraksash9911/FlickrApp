package com.example.nitinflicker.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.nitinflicker.R
import com.example.nitinflicker.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Nitin  on 2020-03-11.
 */

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        btn.setOnClickListener {
            startActivity(Intent(this, ResultScreen::class.java))
        }
    }


}

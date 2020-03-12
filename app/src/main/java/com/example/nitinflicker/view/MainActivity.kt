package com.example.nitinflicker.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import com.example.nitinflicker.R
import com.example.nitinflicker.databinding.ActivityMainBinding

/**
 * Created by Nitin  on 2020-03-11.
 */

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainBinding.eventHandler = EvenHandler(this)

    }

    class EvenHandler(var context: Context) {

        fun gotoResultScreen(view: View) {
            startActivity(context, Intent(view.context, ResultScreen::class.java), null)

        }
    }


}
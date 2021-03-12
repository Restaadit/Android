package com.example.submissionandroidpemula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val actionbar = supportActionBar
        actionbar!!.title= "About"
    }
}
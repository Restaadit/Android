package com.example.submissionandroidpemula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MemberDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_detail)
        val actionbar = supportActionBar
        actionbar!!.title= "Member Detail"

        val tvSetName: TextView = findViewById(R.id.tv_name )
        val tvSetGroup: TextView = findViewById(R.id.tv_group_name)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetBiodata: TextView = findViewById(R.id.tv_detail_content)
        val tvSetFact: TextView = findViewById(R.id.tv_content_fakta)

        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tGroup = intent.getStringExtra(EXTRA_GROUP)
        val tImg = intent.getStringExtra(EXTRA_PHOTO)
        val tBiodata = intent.getStringExtra(EXTRA_BIODATA)
        val tFact = intent.getStringExtra(EXTRA_FACT)

        tvSetName.text = tName
        tvSetGroup.text = tGroup
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetBiodata.text = tBiodata
        tvSetFact.text = tFact
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_GROUP = "extra_group"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_BIODATA = "extra_biodata"
        const val EXTRA_FACT = "extra_fact"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
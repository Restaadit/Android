package com.example.submission1af

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_user_detail.*


class UserDetail : AppCompatActivity() {

    companion object{
        var EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        val actionbar = supportActionBar
        actionbar!!.title= "User Detail"

        val listUser : User = intent.getParcelableExtra(EXTRA_DATA)!!

        dtl_user_avatar.setImageResource(listUser.avatar!!)
        dtl_user_username.text = listUser.username
        dtl_user_name.text = listUser.name
        dtl_user_follower.text = listUser.followers
        dtl_user_following.text = listUser.following
        dtl_user_repo.text = listUser.repository
        dtl_user_location.text = listUser.location
        dtl_user_company.text = listUser.company

    }

}
package com.example.submissionandroidpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMember: RecyclerView
    private var list: ArrayList<Member> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Member List"

        rvMember = findViewById(R.id.rv_member)
        rvMember.setHasFixedSize(true)


        list.addAll(MemberData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvMember.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListMemberAdapter(list)
        rvMember.adapter = listHeroAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAbout = Intent(this@MainActivity,
                        About::class.java)
                startActivity(iAbout)
            }
        }
    }


}
package com.example.locationchecker

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.locationchecker.room.Item
import com.example.locationchecker.room.ItemDatabase

class MainActivity : AppCompatActivity() {
    lateinit var recycleview:RecyclerView
    lateinit var db: RoomDatabase
    lateinit var requiredList: ArrayList<Item>
    lateinit var adapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleview=findViewById(R.id.recyclerview)

        supportActionBar?.title = "Location Checker"

        val actionBar: ActionBar?
        actionBar = supportActionBar
        val colorDrawable = ColorDrawable(Color.parseColor("#800080"))
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(colorDrawable)
        }

        db = Room.databaseBuilder(
            applicationContext, ItemDatabase::class.java, "items"
        ).allowMainThreadQueries().build()

        val meDao = (db as ItemDatabase).itemDao()

        //populate data here
        val a=Item(0,"abhi",10,10)
        val b=Item(0,"prashant",20,20)
        val c=Item(0,"vamsi",30,30)
        val d=Item(0,"jaswanth",40,40)
        val e=Item(0,"sai",50,50)

//        meDao.insertItem(a)
//        meDao.insertItem(b)
//        meDao.insertItem(c)
//        meDao.insertItem(d)
//        meDao.insertItem(e)




        val items: List<Item> = meDao.getAll()
        requiredList = items as ArrayList<Item>

        //adapter
        adapter = ItemAdapter(this, requiredList)
        recycleview.layoutManager = LinearLayoutManager(this)
        recycleview.adapter = adapter


    }
}
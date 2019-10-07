package com.kotlin.roomdatabasedemo.views

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kotlin.roomdatabasedemo.R
import com.kotlin.roomdatabasedemo.adapters.EmpListAdapter
import com.kotlin.roomdatabasedemo.roomdb.EmployeeDatabase
import com.kotlin.roomdatabasedemo.roomdb.EmployeeEntity
import kotlinx.android.synthetic.main.employees_list.*

class EmpListActivity : AppCompatActivity() {

    var database: EmployeeDatabase? = null
    var adapter: EmpListAdapter? = null;
    var empList: List<EmployeeEntity>? = null
    var empRecyclerView: RecyclerView? = null
    var fab: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.employees_list)
        initializeDB()
        initializeViewControls()
    }

    override fun onResume() {
        super.onResume()
        bindList()
    }

    private fun initializeDB() {
        database = Room.databaseBuilder(this, EmployeeDatabase::class.java, "MyDatabase")
            .allowMainThreadQueries().build()
    }

    private fun initializeViewControls() {

        empRecyclerView = findViewById(R.id.rvList)
        fab = findViewById(R.id.fbAdd)
        empList = ArrayList<EmployeeEntity>()
        adapter = EmpListAdapter(this, empList!!)
        empRecyclerView!!.layoutManager = LinearLayoutManager(this)
        empRecyclerView!!.adapter = adapter
        fab!!.setOnClickListener {

            var intent = Intent(this, RegisterEmployeeActivity::class.java)
            startActivity(intent)

        }
    }

    private fun bindList() {
        database!!.getEmployeeDao().getAllEmployees().observe(this, Observer {

            if(it.isNotEmpty()) {
                rvList.visibility = View.VISIBLE
                tvError.visibility = View.GONE
                adapter!!.refresh(it)
            }
            else
            {
                rvList.visibility = View.GONE
                tvError.visibility = View.VISIBLE

            }

        })
    }
}

package com.kotlin.roomdatabasedemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.roomdatabasedemo.R
import com.kotlin.roomdatabasedemo.roomdb.EmployeeEntity

class EmpListAdapter(var context: Context, var empList: List<EmployeeEntity>) :

    RecyclerView.Adapter<EmpListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view: View? = LayoutInflater.from(context).inflate(R.layout.employee_list_cell, null)
        return MyViewHolder(view!!)
    }

    fun refresh(empList: List<EmployeeEntity>) {
        this.empList = empList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = empList!!.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvName.text = empList.get(position).name
        holder.tvAddress.text = empList.get(position).address

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvName: TextView = itemView.findViewById(R.id.tvName)
        var tvAddress: TextView = itemView.findViewById(R.id.tvAddress)


    }
}
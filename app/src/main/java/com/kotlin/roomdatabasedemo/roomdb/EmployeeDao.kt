package com.kotlin.roomdatabasedemo.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EmployeeDao {
    @Insert
    fun insert(employee: EmployeeEntity): Long

    @Update
    fun update(employee: EmployeeEntity): Int

    @Delete
    fun delete(employee: EmployeeEntity)

    @Query("SELECT * FROM employee")
    fun getAllEmployees(): LiveData<List<EmployeeEntity>>

    @Query("SELECT * FROM employee WHERE contact_email LIKE:email")
    fun getEmployeeByEmailId(email: String): LiveData<List<EmployeeEntity>>

}
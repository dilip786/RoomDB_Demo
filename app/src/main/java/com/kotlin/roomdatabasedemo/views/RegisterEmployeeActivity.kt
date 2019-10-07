package com.kotlin.roomdatabasedemo.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.room.Room
import com.kotlin.roomdatabasedemo.roomdb.EmployeeDatabase
import com.kotlin.roomdatabasedemo.roomdb.EmployeeEntity
import kotlinx.android.synthetic.main.register_employee_form.*


class RegisterEmployeeActivity : AppCompatActivity() {

    var database: EmployeeDatabase? = null
    var employeeDo: EmployeeEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.kotlin.roomdatabasedemo.R.layout.register_employee_form)

        initializeDB()

        btnSaveInDb.setOnClickListener {
            insertDetailsIntoDB()
        }
    }

    private fun initializeDB() {
        database = Room.databaseBuilder(this, EmployeeDatabase::class.java, "MyDatabase")
            .allowMainThreadQueries().build()
    }

    private fun insertDetailsIntoDB() {
        employeeDo =
            EmployeeEntity(
                etName.text.toString(),
                etID.text.toString(),
                etEmail.text.toString(),
                etContactNumber.text.toString(),
                etAddress.text.toString()
            )

        database!!.getEmployeeDao().getEmployeeByEmailId(etEmail.text.toString()).observe(this,
            Observer {

                if (it.isEmpty()) {
                    var effectedRowsCount = database!!.getEmployeeDao().insert(employeeDo!!)
                    if (!effectedRowsCount.equals(0))
                        showToast("Details Inserted Successfully")

                    finish()

                } else {
                    var effectedRowsCount = database!!.getEmployeeDao().update(employeeDo!!)
                    if (!effectedRowsCount.equals(0))
                        showToast("Details Updated Successfully")

                    finish()

                }
            })
    }

    private fun showToast(message: String) {
        Toast.makeText(this, "Details Inserted", Toast.LENGTH_LONG).show()

    }

}

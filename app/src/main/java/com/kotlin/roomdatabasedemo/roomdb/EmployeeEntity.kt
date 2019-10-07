package com.kotlin.roomdatabasedemo.roomdb

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
class EmployeeEntity{

    @ColumnInfo(name = "contact_name")
    var name: String? = null

    @ColumnInfo(name = "contact_id")
    var id: String? = null

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "contact_email")
    @NonNull
    var email: String? = null

    @ColumnInfo(name = "contact_contact")
    var contactNo: String? = null

    @ColumnInfo(name = "contact_address")
    var address: String? = null


    constructor(name: String, id: String, email: String, contactNo: String, address: String) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.contactNo = contactNo;
        this.address = address;
    }

}
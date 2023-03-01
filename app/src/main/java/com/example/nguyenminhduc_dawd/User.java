package com.example.nguyenminhduc_dawd;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

 @Entity(tableName = "user")
    public class User  {
        @PrimaryKey(autoGenerate = true)
        public int id;

        @ColumnInfo(name = "employee")
        public String employee;
        @ColumnInfo(name ="des")
        public String designation;

        @ColumnInfo(name ="salary")
        public String salary;

    }

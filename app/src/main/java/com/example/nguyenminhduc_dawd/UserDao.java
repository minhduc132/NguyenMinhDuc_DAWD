package com.example.nguyenminhduc_dawd;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    abstract long insertUser(User user);

    @Update
    abstract int updateUser(User user);

    @Delete
    abstract int deleteUser(User user);

    @Query("Select * from user where id =:id")
    User findUser(int id);

    @Query("Select *from user")
    List<User> getAllEmployee();





}

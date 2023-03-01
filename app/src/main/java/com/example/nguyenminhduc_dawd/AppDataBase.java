package com.example.nguyenminhduc_dawd;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

    @Database(entities = {User.class},version = 1)
    public abstract class AppDataBase extends RoomDatabase {


        private static AppDataBase appDataBase;
        public  abstract UserDao userDao();

        public  static  AppDataBase getAppDataBase(Context context){
            if(appDataBase ==null){
                appDataBase = Room.databaseBuilder(context,AppDataBase.class,
                        "User.db").allowMainThreadQueries().build();
            }
            return  appDataBase;
        }


}

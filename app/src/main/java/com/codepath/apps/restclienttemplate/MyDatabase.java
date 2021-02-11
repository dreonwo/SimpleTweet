package com.codepath.apps.restclienttemplate;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.codepath.apps.restclienttemplate.models.Organization;
import com.codepath.apps.restclienttemplate.models.SampleModel;
import com.codepath.apps.restclienttemplate.models.SampleModelDao;

@Database(entities={Organization.User.class}, version=1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract Organization.UserDao userDao();

    // Database name to be used
    public static final String NAME = "MyDataBase";
}

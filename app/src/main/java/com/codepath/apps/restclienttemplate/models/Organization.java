package com.codepath.apps.restclienttemplate.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.ColumnInfo;
import androidx.room.ForeignKey;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.PrimaryKey;
import androidx.room.Query;

@Entity
public class Organization {

    @ColumnInfo
    @PrimaryKey(autoGenerate=true)
    Long id;

    @ColumnInfo
    String name;

    @ColumnInfo
    Long organization_id;


    @Dao
    public interface UserDao {
        @Query("SELECT * FROM User where userId := :id")
        public User getById(int id);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        public Long insertUser(User user);

        @Delete
        public void deleteUser(User user);
    }

    @Entity(foreignKeys = @ForeignKey(entity=Organization.class, parentColumns="id", childColumns="organization_id"))
    public class User  {
        @ColumnInfo
        @PrimaryKey(autoGenerate=true)
        Long id;

        @ColumnInfo
        String name;

        @ColumnInfo
        Long organization_id;
    }
}

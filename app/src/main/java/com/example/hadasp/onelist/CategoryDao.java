package com.example.hadasp.onelist;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by hadasp on 17/12/2017.
 */

@Dao
public interface CategoryDao {
    @Query("SELECT * FROM Category")
    List<Category> getAllCategories();

    @Query("SELECT * FROM Category WHERE id = :id")
    Category getCategoryById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllCategories(Category... categories);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategory(Category category);

    @Delete
    void deleteCategory(Category category);

    @Update
    void updateCategory(Category category);
}

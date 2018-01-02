package com.example.hadasp.onelist;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by hadasp on 10/12/2017.
 */

@Dao
public interface NoteDao {

    @Query("SELECT * FROM Notes")
    List<Note> getAllNotes();

    @Query("SELECT * FROM Notes WHERE id = :id")
    Note getNoteById(int id);

    @Query("SELECT * FROM Notes WHERE category0 = :isCategory ")
    List<Note> getNotesByCategory0(boolean isCategory);
    @Query("SELECT * FROM Notes WHERE category1 = :isCategory ")
    List<Note> getNotesByCategory1(boolean isCategory);
    @Query("SELECT * FROM Notes WHERE category2 = :isCategory ")
    List<Note> getNotesByCategory2(boolean isCategory);
    @Query("SELECT * FROM Notes WHERE category3 = :isCategory ")
    List<Note> getNotesByCategory3(boolean isCategory);
    @Query("SELECT * FROM Notes WHERE category4 = :isCategory ")
    List<Note> getNotesByCategory4(boolean isCategory);
    @Query("SELECT * FROM Notes WHERE category5 = :isCategory ")
    List<Note> getNotesByCategory5(boolean isCategory);
    @Query("SELECT * FROM Notes WHERE category6 = :isCategory ")
    List<Note> getNotesByCategory6(boolean isCategory);
    @Query("SELECT * FROM Notes WHERE category7 = :isCategory ")
    List<Note> getNotesByCategory7(boolean isCategory);
    @Query("SELECT * FROM Notes WHERE category8 = :isCategory ")
    List<Note> getNotesByCategory8(boolean isCategory);
    @Query("SELECT * FROM Notes WHERE category9 = :isCategory ")
    List<Note> getNotesByCategory9(boolean isCategory);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllNotes(Note... notes);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Update
    void updateNote(Note note);
}

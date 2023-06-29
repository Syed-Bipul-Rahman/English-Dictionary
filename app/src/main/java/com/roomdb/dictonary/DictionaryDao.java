package com.roomdb.dictonary;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DictionaryDao {
    @Query("SELECT * FROM dictionary_entries WHERE word = :word")
    DictionaryEntry getDictionaryEntry(String word);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDictionaryEntry(DictionaryEntry entry);
}


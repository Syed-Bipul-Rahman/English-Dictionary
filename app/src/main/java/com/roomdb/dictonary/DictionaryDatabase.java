package com.roomdb.dictonary;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DictionaryEntry.class}, version = 1, exportSchema = false)
public abstract class DictionaryDatabase extends RoomDatabase {
    public abstract DictionaryDao getDictionaryDao();
}
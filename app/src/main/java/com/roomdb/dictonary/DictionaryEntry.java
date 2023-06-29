package com.roomdb.dictonary;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "dictionary_entries")
public class DictionaryEntry {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "word")
    private String word;

    @ColumnInfo(name = "definition")
    private String definition;

    public DictionaryEntry(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    // Getters and setters for id, word, and definition

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}


package com.roomdb.dictonary;

import java.util.List;

public class DictionaryDefinitionItem {
    private String definition;
    private List<String> synonyms;
    private List<String> antonyms;

    // Add getters and setters
    public DictionaryDefinitionItem() {
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public List<String> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(List<String> antonyms) {
        this.antonyms = antonyms;
    }
}
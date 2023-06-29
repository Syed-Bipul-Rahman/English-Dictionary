package com.roomdb.dictonary;
import java.util.List;

public class DictionaryMeaning {
    private String partOfSpeech;
    private List<DictionaryDefinitionItem> definitions;
    private List<String> synonyms;
    private List<String> antonyms;
    private String example;

    // Add getters and setters
    public DictionaryMeaning() {
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<DictionaryDefinitionItem> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<DictionaryDefinitionItem> definitions) {
        this.definitions = definitions;
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

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
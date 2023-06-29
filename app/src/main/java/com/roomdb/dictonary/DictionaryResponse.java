package com.roomdb.dictonary;

import java.util.List;

public class DictionaryResponse {
    private String word;
    private List<DictionaryPhonetic> phonetics;
    private List<DictionaryMeaning> meanings;
    private DictionaryLicense license;
    private List<String> sourceUrls;

    // Add getters and setters
    public DictionaryResponse() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<DictionaryPhonetic> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<DictionaryPhonetic> phonetics) {
        this.phonetics = phonetics;
    }

    public List<DictionaryMeaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<DictionaryMeaning> meanings) {
        this.meanings = meanings;
    }

    public DictionaryLicense getLicense() {
        return license;
    }

    public void setLicense(DictionaryLicense license) {
        this.license = license;
    }

    public List<String> getSourceUrls() {
        return sourceUrls;
    }

    public void setSourceUrls(List<String> sourceUrls) {
        this.sourceUrls = sourceUrls;
    }
}


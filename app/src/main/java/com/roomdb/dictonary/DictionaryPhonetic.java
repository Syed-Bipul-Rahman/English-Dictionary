package com.roomdb.dictonary;

public class DictionaryPhonetic {
    private String text;
    private String audio;
    private String sourceUrl;
    private DictionaryLicense license;
    public DictionaryPhonetic() {
    }
    // Add getters and setters

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public DictionaryLicense getLicense() {
        return license;
    }

    public void setLicense(DictionaryLicense license) {
        this.license = license;
    }
}
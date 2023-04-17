package com.example.dictionary.Models;

import java.util.List;

public class APIResponse {
    String word ="";
    List<Phonetic> phonetic = null;
    List<Meaning> meanings = null;

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Phonetic> getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(List<Phonetic> phonetic) {
        this.phonetic = phonetic;
    }
}

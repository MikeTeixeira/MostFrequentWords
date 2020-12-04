package com.mostfrequentwords;

public class Word extends TextCounter {
    private String word;
    private int count;


    public Word(String word, int count){
        this.word = word;
        this.count = count;
    }


    public void setCount(int count){
        this.count = count;
    }

    public int getCount(){
        return this.count;
    }

    public String getWord(){
        return this.word;
    }

    @Override
    public String toString() {
        return "com.mostfrequentwords.Word: " + word + " ---------- Number of times appeared: " + count;
    }
}


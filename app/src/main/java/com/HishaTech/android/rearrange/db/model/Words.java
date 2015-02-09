package com.HishaTech.android.rearrange.db.model;

/**
 * Created by smithkev on 2/9/2015.
 */
public class Words {

    private Integer id;
    private String word;
    private Integer lettercount;

    public Integer getID() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String Word) {
        this.word = Word;
    }

    public Integer getLetterCount() {
        return lettercount;
    }

    public void setLetterCount(Integer LetterCount) {
        this.lettercount = LetterCount;
    }

}

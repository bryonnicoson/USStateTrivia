package com.bryonnicoson.usstatetrivia;

/**
 * Created by bryon on 6/11/16.
 */
public class State {

    String mAbbr;
    String mName;
    String mDate;
    String mCapital;
    String mBird;
    String mTree;
    String mFlower;

    public State(String abbr, String name, String date, String capital, String bird, String tree, String flower) {
        this.mAbbr = abbr;
        this.mName = name;
        this.mDate = date;
        this.mCapital = capital;
        this.mBird = bird;
        this.mTree = tree;
        this.mFlower = flower;
    }

    public String getAbbr() { return mAbbr; }
    public String getName() { return mName; }
    public String getDate() { return mDate; }
    public String getCapital() { return mCapital; }
    public String getBird() { return mBird; }
    public String getTree() { return mTree; }
    public String getFlower() { return mFlower; }

}
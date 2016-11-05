package com.lentzos.nic.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Nic on 26/10/2016.
 */

public class Crime {
    private UUID mId;
    private String mTitle;

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    private Date mDate;

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    private boolean mSolved;

    public Crime() {
       this(UUID.randomUUID());
    }
    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
    }
    //getter for mId
    public UUID getId() {
        return mId;
    }
    //getter for mTitle
    public String getTitle() {
        return mTitle;
    }
    //setter for mTitle
    public void setTitle(String title) {
        mTitle = title;
    }


}

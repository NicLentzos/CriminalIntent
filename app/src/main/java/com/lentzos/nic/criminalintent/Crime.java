package com.lentzos.nic.criminalintent;

import java.util.UUID;

/**
 * Created by Nic on 26/10/2016.
 */

public class Crime {
    private UUID mId;
    private String mTitle;

    public Crime() {
        //generate unique identifier
        mId = UUID.randomUUID();
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

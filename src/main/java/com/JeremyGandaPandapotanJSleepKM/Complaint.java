package com.JeremyGandaPandapotanJSleepKM;

import com.JeremyGandaPandapotanJSleepKM.dbjson.*;

/**
 * Write a description of class Complaint here.
 *
 * @author Jeremy Ganda Pandapotan
 * @version (a version number or a date)
 */
public class Complaint extends Serializable
{
    public String desc, date;

    Complaint( String date, String desc){
        super();
        this.desc = desc;
        this.date = date;
    }

    public String toString() {
        return "\nDate: " + date + "\nDesc: " + desc;
    }
}

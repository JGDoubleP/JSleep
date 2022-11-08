package com.JeremyGandaPandapotanJSleepKM;
import com.JeremyGandaPandapotanJSleepKM.dbjson.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Renter here.
 *
 * @author Jeremy Ganda Pandapotan
 * @version (a version number or a date)
 */
public class Renter extends Serializable
{
    public String phoneNumber;
    public String address = "";
    public String username;
    public static final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{4,20}$";
    public static final String REGEX_PHONE = "^[0-9]{9,12}$";

    
    Renter( String username, String phoneNumber, String address){
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    public boolean validate(){
        if (username.matches(REGEX_NAME) && phoneNumber.matches(REGEX_PHONE)){
            return true;
        }
        else{
            return false;
        }
    }
}

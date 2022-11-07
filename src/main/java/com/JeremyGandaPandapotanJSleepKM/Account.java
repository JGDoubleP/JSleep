package com.JeremyGandaPandapotanJSleepKM;

/**
 * Write a description of class Serializable here.
 *
 * @author Jeremy Ganda Pandapotan
 * @version (a version number or a date)
 */
public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;
    public static final String REGEX_EMAIL = "^\\w+@\\w+([\\.-]?\\w+)*.?\\w+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    
    public Account( String name, String email, String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
       
    }

    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nEmail: " + email + "\nPassoword: " + password;
    }
    
    public boolean validate(){
        if (email.matches(REGEX_EMAIL) && password.matches(REGEX_PASSWORD)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Object write()
    {
        return null;
    }
    public boolean read(String content)
    {
        return false;
    }
}

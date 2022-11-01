package JeremyGandaPandapotanJSleepKM;
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
    public static final String REGEX_NAME = "[A-Z][a-z0-9_-]{4,20}$";
    public static final String REGEX_PHONE = "[0-9]{9,12}";

    /*
    Renter( String username){
        super();
        this.username = username;
    }

    Renter(String username, String address){
        super();
        this.username = username;
        this.address = address;
    }

    Renter( String username, int phoneNumber){
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
*/
    
    Renter( String username, String phoneNumber, String address){
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    public boolean validate () {
    	Pattern patternUsername = Pattern.compile(REGEX_NAME);
    	Matcher UsernameMatcher = patternUsername.matcher(this.username);
    	Pattern patternPhonenumber = Pattern.compile(REGEX_PHONE);
    	Matcher PhonenumberMatcher = patternPhonenumber.matcher(this.phoneNumber);
    	return UsernameMatcher.find() && PhonenumberMatcher.find();
    }
}

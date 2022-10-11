package JeremyGandaPandapotanJSleepKM;


/**
 * Write a description of class Renter here.
 *
 * @author Jeremy Ganda Pandapotan
 * @version (a version number or a date)
 */
public class Renter extends Serializable
{
    public int phoneNumber = 0;
    public String address = "";
    public String username;

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

    Renter( String username, int phoneNumber, String address){
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}

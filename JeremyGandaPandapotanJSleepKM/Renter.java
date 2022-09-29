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

    Renter(int id, String username){
        super(id);
        this.username = username;
    }

    Renter(int id, String username, String address){
        super(id);
        this.username = username;
        this.address = address;
    }

    Renter(int id, String username, int phoneNumber){
        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    Renter(int id, String username, int phoneNumber, String address){
        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}

package JeremyGandaPandapotanJSleepKM;


/**
 * Write a description of class Renter here.
 *
 * @author Jeremy Ganda Pandapotan
 * @version (a version number or a date)
 */
public class Renter extends Serializable
{
    public int phonenumber = 0;
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

    Renter(int id, String username, int phonenumber){
        super(id);
        this.username = username;
        this.phonenumber = phonenumber;
    }

    Renter(int id, String username, int phonenumber, String address){
        super(id);
        this.username = username;
        this.phonenumber = phonenumber;
        this.address = address;
    }
}

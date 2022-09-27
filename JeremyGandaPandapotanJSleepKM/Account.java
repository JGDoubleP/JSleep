package JeremyGandaPandapotanJSleepKM;

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
    
    Account(int id, String name, String email, String password){
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

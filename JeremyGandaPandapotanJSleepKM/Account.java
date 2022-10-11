package JeremyGandaPandapotanJSleepKM;

/**
 * Write a description of class Serializable here.
 *
 * @author Jeremy Ganda Pandapotan
 * @version (a version number or a date)
 */
public class Account extends Serializable implements FileParser
{
    public String name;
    public String email;
    public String password;
    
    Account( String name, String email, String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nEmail: " + email + "\nPassoword: " + password;
    }
    
    @Override
    public Object Write(){
        return null;
    }

    @Override
    public boolean read(String content){
        return false;
    }
    
    
}

package JeremyGandaPandapotanJSleepKM;


/**
 * Write a description of class JSleep here.
 *
 * @author Jeremy Ganda Pandapotan
 * 
 */

public class JSleep
{
    public static void main(String[] args){
    Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");
    Price testPrice = new Price(100000, 20000);
    Room testRoom = new Room(1, "Presidential Suite", 5, testPrice,
    Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
    Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
    Rating testRating = new Rating();
    System.out.println(testComplain.toString());
    System.out.println(testRoom.toString());
    System.out.println(testAccount.toString());
    System.out.println(testPrice.toString());
    System.out.println(testRating.toString());
    }
    
}




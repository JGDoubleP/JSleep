package JeremyGandaPandapotanJSleepKM;
import java.util.*;
import java.text.*;
/**
 * Write a description of class Payment here.
 *
 * @author Jeremy Ganda Pandapotan
 * @version (a version number or a date)
 */
public class Payment extends Invoice {
    public Date to;
    public Date from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, int roomId) {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = new Date();
        this.to = new Date();
        this.to.setDate(this.from.getDate() + 2);
    }

    public Payment(int id, Account buyer, Renter renter, int roomId) {
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = new Date();
        this.to = new Date();
        this.to.setDate(this.from.getDate() + 2);
    }
    
    public String getTime(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        return "Formatted Date = " + SDFormat.format(this.from.getTime());
    }
    
    public static boolean makeBooking(Date from, Date to, Room room){
        if (availability(from, to, room) == true){
            room.booked.add(from);
            room.booked.add(to);
            return true;
        }
        else{
            return false;
        }
    }
    /*
    public String getDuration(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        return "" + SDFormat.format(this.from.getTime()) + " - " + SDFormat.format(this.to.getTime());
    }
*/
    public String print() {
        return "\nRoomId = " + roomId + "\nFrom = " + from + "\nTo = " + to;
    }

    public int getRoomId() {
        return roomId;
    }

    public static boolean availability(Date from, Date to, Room room){
        
        //error handling
        if(to.compareTo(from) < 0)
        {
            return false;
        }

        else if(room.booked.isEmpty())
        {
            return true;
        }

        else
        {

            for(int i = 0; i < room.booked.size(); i++)
            {
                if(room.booked.get(i).compareTo(from) == 0 || room.booked.get(i).compareTo(to) == 0)
                {
                    return false;
                }
            }
            return true;
        }
    }
}

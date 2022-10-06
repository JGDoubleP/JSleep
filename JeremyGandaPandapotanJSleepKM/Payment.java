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
    public Calendar to;
    public Calendar from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, int roomId) {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }

    public Payment(int id, Account buyer, Renter renter, int roomId) {
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }
    
    public String getTime(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        return "" + SDFormat.format(this.from.getTime());
    }
    
    public String getDuration(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        return "" + SDFormat.format(this.from.getTime()) + " - " + SDFormat.format(this.to.getTime());
    }

    public String print() {
        return "\nRoomId = " + roomId + "\nFrom = " + from + "\nTo = " + to;
    }

    public int getRoomId() {
        return roomId;
    }
}

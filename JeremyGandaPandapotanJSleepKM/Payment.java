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
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = new Date();
        this.to = new Date();
        this.to.setDate(this.from.getDate() + 2);
    }

    public Payment(int id, Account buyer, Renter renter, int roomId) {
        super(buyer, renter);
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
    	Calendar temp = Calendar.getInstance();
    	if (availability(from, to, room) == true) {
        while (from.before(to)){
            room.booked.add(from);
            temp.setTime(from);
            temp.add(Calendar.DATE, 1);
            from = temp.getTime();
        	}
        return true;
    	}
    	
    	else {
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
        if(to.before(from))
        {
            return false;
        }
        
        else {
        for(Date index : room.booked) {
        	if(from.equals(index)) {
        		return false;
        	}
        	
        	else if(from.before(index) && to.after(index)) {
        		return false;
        	}
        }
        return true;
        }
    }
}

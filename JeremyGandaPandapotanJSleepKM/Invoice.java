package JeremyGandaPandapotanJSleepKM;
import java.util.*;

/**
 * Write a description of class Invoice here.
 *
 * @author Jeremy Ganda Pandapotan
 * @version (a version number or a date)
 */
public class Invoice extends Serializable
{
    public int buyerId;
    public int renterId;
    public Calendar time;
    public RoomRating rating;
    public PaymentStatus status;

    protected Invoice(int id, int buyerId, int renterId){
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = Calendar.getInstance();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    public Invoice(int id, Account buyer, Renter renter){
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
        this.time = Calendar.getInstance();
    }

    public String print(){
        return "buyerId = " + buyerId + "\nrenterid = " + renterId + "\nTime= " + time;
    }

    public enum RoomRating{
        NONE, BAD, NEUTRAL, GOOD
    }

    public enum PaymentStatus{
        FAILED, WAITING, SUCCESS
    }
}

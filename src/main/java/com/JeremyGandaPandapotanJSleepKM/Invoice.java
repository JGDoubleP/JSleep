package com.JeremyGandaPandapotanJSleepKM;
import com.JeremyGandaPandapotanJSleepKM.dbjson.*;
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
//    public Date time;
    public RoomRating rating;
    public PaymentStatus status;

    protected Invoice( int buyerId, int renterId){
        super();
        this.buyerId = buyerId;
        this.renterId = renterId;
//        this.time = new Date();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    public Invoice( Account buyer, Renter renter){
        super();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
//        this.time = new Date();
    }

    public String print(){
        return "buyerId = " + buyerId + "\nrenterid = " + renterId /*+ "\nTime= " + time*/;
    }

    public enum RoomRating{
        NONE, BAD, NEUTRAL, GOOD
    }

    public enum PaymentStatus{
        FAILED, WAITING, SUCCESS
    }
}

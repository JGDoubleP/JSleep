package com.JeremyGandaPandapotanJSleepKM;
import java.util.*;
import java.text.*;
/**
 * Write a description of class Payment here.
 *
 * @author Jeremy Ganda Pandapotan
 * @version (a version number or a date)
 */
public class Payment extends Invoice {
    /**
     * The date on which the rental period ends.
     */
    public Date to;

    /**
     * The date on which the rental period begins.
     */
    public Date from;

    /**
     * The total price of the rental.
     */
    public double totalPrice;

    /**
     * The ID of the room that is being rented.
     */
    public int roomId;

    /**
     * Creates a new `Payment` with the given buyer, renter, and rental information.
     *
     * @param buyerId the ID of the buyer making the payment.
     * @param renterId the ID of the renter who is receiving the payment.
     * @param roomId the ID of the room being rented.
     * @param from the date on which the rental period begins.
     * @param to the date on which the rental period ends.
     */
    public Payment(int buyerId, int renterId, int roomId, Date from, Date to) {
        super(buyerId, renterId);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    /**
     * Creates a new `Payment` with the given buyer, renter, and rental information.
     *
     * @param buyer the buyer making the payment.
     * @param renter the renter who is receiving the payment.
     * @param roomId the ID of the room being rented.
     * @param from the date on which the rental period begins.
     * @param to the date on which the rental period ends.
     */
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to) {
        super(buyer, renter);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    /**
     * Returns whether the given rental period is available for the specified room.
     *
     * @param from the date on which the rental period begins.
     * @param to the date on which the rental period ends.
     * @param room the room being rented.
     * @return `true` if the rental period is available for the room, `false` otherwise.
     */
    public static boolean availability(Date from, Date to, Room room) {
        if (to.compareTo(from) < 0 || to.compareTo(from) == 0) {
            return false;
        } else {
            for (Date inc : room.booked) {
                if (from.equals(inc)) {
                    return false;
                } else if (from.before(inc)) {
                    if (from.before(inc) && to.after(inc)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /**
     * Makes a booking for the specified rental period in the given room.
     *
     * @param from the date on which the rental period begins.
     * @param to the date on which the rental period ends.
     * @param room the room being rented.
     * @return `true` if the booking was successful, `false` otherwise.
     */
    public static boolean makeBooking(Date from, Date to, Room room) {
        if (availability(from, to, room) == true) {
            Calendar tmp = Calendar.getInstance();
            while (from.before(to)) {
                room.booked.add(from);
                tmp.setTime(from);
                tmp.add(Calendar.DATE, 1);
                from = tmp.getTime();
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a string representation of the `Payment`, including the dates of the rental period and the ID of the rented room.
     *
     * @return a string representation of the `Payment`.
     */
    public String print() {
        String prin = "Hasil Output\n" + "To : " + this.to + "\nFrom : " + this.from + "\nRoom ID : " + this.roomId;
        return prin;
    }

    /**
     * Returns the ID of the room associated with the `Payment`.
     *
     * @return the ID of the room associated with the `Payment`.
     */
    public int getRoomId() {
        return this.roomId;
    }
}

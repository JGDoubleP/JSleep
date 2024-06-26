package com.JeremyGandaPandapotanJSleepKM;
import com.JeremyGandaPandapotanJSleepKM.dbjson.*;

import java.util.*;

/**
 * Write a description of class Serializable here.
 *
 * @author Jeremy Ganda Pandapotan
 * @version (a version number or a date)
 */
public class Room extends Serializable {
    public int size;
    public String name;
    public Price price;
    public ArrayList <Facility> facility;
    public BedType bedType;
    public City city;
    public String address;
    public ArrayList<Date> booked = new ArrayList<Date>();
    public int accountId;

    public Room(int accountId, String name, int size, Price price, ArrayList<Facility> facility,BedType bedType, City city, String address) {
        super();
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = new ArrayList<>(facility);
        this.city = city;
        this.address = address;
        this.bedType = bedType;
    }

    public String toString() {

        return "\nID :" + id + "\nName: " + name + "\nSize: " + size + "\nFacility: " + facility + "\nCity: " + city + "\naddress: "
                + address
                + "\nBedtype: " + bedType;
    }

    public Object write()
    {
        return null;
    }
    public boolean read(String content)
    {
        return false;
    }
}

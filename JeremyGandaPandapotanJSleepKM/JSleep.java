package JeremyGandaPandapotanJSleepKM;
import java.util.*;
import java.sql.Date;

/**
 * Write a description of class JSleep here.
 *
 * @author Jeremy Ganda Pandapotan
 * 
 */

public class JSleep
{
    public static void main(String args[]){
        
    	ArrayList<Room> RoomSerialized = new ArrayList<Room>();
        
        for(int i = 0; i<5; i++){
            RoomSerialized.add(i, JSleep.createRoom());
            System.out.println(RoomSerialized.get(i).toString());
        }
    }

    public static Room createRoom(){
        Price price = new Price(100000, 5);
        Room room = new Room("JG" , 2, price, Facility.AC, City.JAKARTA, "Jl. Terus");

        return room;
    }
}



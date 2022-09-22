package JeremyGandaPandapotanJSleepKM;


/**
 * Write a description of class JSleep here.
 *
 * @author Jeremy Ganda Pandapotan
 * 
 */

public class JSleep
{
    //modul 1
    public static void main(String[] args){
        Room test = createRoom();
        System.out.println(test.name);
        System.out.println(test.size);
        System.out.println(test.price.price);
        System.out.println(test.facility);
    }

    public static Room createRoom(){
        Price price = new Price (100000, 5);
        Room room = new Room ("hotel", 30, price, Facility.AC);
        return room;
    }
    
}




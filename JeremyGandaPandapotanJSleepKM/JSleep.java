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
        Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice(2,2,2, "");
        System.out.println(testRoom.print());
        System.out.println(testInvoice.print());
    }
    
}




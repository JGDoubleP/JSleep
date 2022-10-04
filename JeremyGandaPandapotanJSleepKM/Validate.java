package JeremyGandaPandapotanJSleepKM;
import java.util.*;
import java.util.ArrayList;


public class Validate
{
    public Validate(){
        
    }
    
    public static ArrayList filter(Price[] list,int value, boolean less){
        ArrayList arrList = new ArrayList<>();
        
        for (Price pr : list){
            if (less && pr.price <= value){
                arrList.add(pr.price);
            }
            else if (less == false && pr.price > value){
                arrList.add(pr.price);
            }
        }
        return arrList;
    }
}

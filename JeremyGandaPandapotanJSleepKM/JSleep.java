package JeremyGandaPandapotanJSleepKM;


/**
 * Write a description of class JSleep here.
 *
 * @author Jeremy Ganda Pandapotan
 * 
 */
public class JSleep
{
    public static void main(String args[]){
        int getid;
        getid = getHotelId();
        System.out.println(getid);
        
        String Name = getHotelName();
        System.out.println(Name);

        boolean X = isDiscount();
        System.out.println(X);

        int before = 1000;
        int after = 900;
        float Percentage = getDiscountPercentage(before, after);
        System.out.println(Percentage);
    }

    public static int getHotelId()
    {
        return 0;
    }
    
    public static String getHotelName(){
        return "Hotel";
    }

    public static boolean isDiscount(){
        return true;
    }

    public static float getDiscountPercentage(int beforeDiscount,int afterDiscount){
        float DiscountPercentage = 0.0f;
        if (beforeDiscount == afterDiscount) {
            DiscountPercentage = 0.0f;
        }
        else{
            DiscountPercentage = (float)(beforeDiscount - afterDiscount) / beforeDiscount;
        }
        return DiscountPercentage;
    }
}

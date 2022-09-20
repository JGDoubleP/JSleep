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
    public static void main(String args[]){
        int getid;
        getid = getHotelId();
        System.out.println("Hotel Id: "+ getid);
        
        String Name = getHotelName();
        System.out.println(Name);

        boolean X = isDiscount();
        System.out.println("Is Discount: "+ X);

        int before = 1000;
        int after = 900;
        float Percentage = getDiscountPercentage(before, after);
        System.out.println("Discount Percentage: "+ Percentage);

        int Discounted = getDiscountedPrice(before, Percentage);
        System.out.println("Discounted Price: "+ Discounted);

        int Original = getrOriginalPrice(Discounted, Percentage);
        System.out.println("Original Price: "+ Original);
        
    //modul 2
    

    }

    //modul 1
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

    public static int getDiscountedPrice(int price, float discountPercentage){
        int DiscountedPrice = 0;
        if (discountPercentage >= 100.0f) {
            discountPercentage = 100.0f;
            DiscountedPrice =(int) (price - (price * discountPercentage));
        }
        else{
            DiscountedPrice =(int) (price - (price * discountPercentage));
        }
        return DiscountedPrice;
    }

    public static int getrOriginalPrice(int discountedPrice, float discountPercentage){
        int OriginalPrice = (int) (discountedPrice / (1 - discountPercentage));
        return OriginalPrice;
    }
    
    
    
}




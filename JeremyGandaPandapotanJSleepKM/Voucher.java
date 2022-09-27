package JeremyGandaPandapotanJSleepKM;


public class Voucher extends Serializable
{
   public Type type;
   public double cut;
   public String name;
   public int code;
   public double minimum;
   private boolean used;

   public Voucher(int id, String name, int code, Type type, double minimum, double cut){
    super(id);
    this.name = name;
    this.code = code;
    this.type = type;
    this.minimum = minimum;
    this.cut = cut;
   }

   public boolean isUsed(){
    return used;
   }

   public boolean canApply(Price price){
    if(price.price > minimum && used == false){
        return true;
    }
    else{
        return false;
    }
   }

   public double apply(Price price){
    used = true;
    if (type == Type.DISCOUNT){
        if(cut/100 == 100){
            return 0;
        }else if(cut/100 > 100){
            return 0;
        }
        return price.price - (price.price * cut/100);
    }
    else{
        if(cut > price.price){
            cut = price.price;
        }
        return price.price - cut;
    }
   }
}
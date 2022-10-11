package JeremyGandaPandapotanJSleepKM;


public class Voucher extends Serializable implements FileParser
{
   public Type type;
   public double cut;
   public String name;
   public int code;
   public double minimum;
   private boolean used;

   public Voucher( String name, int code, Type type, double minimum, double cut){
    super();
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
        if(price.price - (price.price * cut / 100) >= 0){
                return price.price - (price.price * cut / 100);
            }
            else{
                return 0;
            }
    }
    else if(type ==Type.REBATE){
        if(price.price - cut < 0)
            {
                return 0;
            }
            else
            {
                return price.price - cut;
            }
    }
    else{
        return price.price;
    }
   }
   
   @Override
   public Object Write(){
        return null;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
}
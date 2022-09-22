package JeremyGandaPandapotanJSleepKM;


public class Voucher
{
   public Type type;
   public double cut;
   public String name;
   public int code;
   public double minimum;
   private boolean used;

   public Voucher(String name, int code, Type type, double minimum, double cut){
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
  /* 
  public double getDiscountedPrice(){

    if (discount == 100){
      return 0;
    }
    else if (discount > 100){
      discount = 100;
    }

    return price - (price * discount) / 100;//Discount berbentuk int maka jika ingin menjadi percent maka dibagi 100
  }

  public double getRebatedPrice (){
    if (rebate > price){
      rebate = price;
    }
    return price - rebate;
  }
  */
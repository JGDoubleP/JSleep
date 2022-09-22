package JeremyGandaPandapotanJSleepKM;

public class Price
{
  //declaration variable
   public double price;
   public double discount;
    
  public Price(double price){
   this.price = price;
   this.discount = 0;
  }

  public Price(double price , double discount){
    this.price = price;
    this.discount = discount;
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
}

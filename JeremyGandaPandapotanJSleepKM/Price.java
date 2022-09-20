package JeremyGandaPandapotanJSleepKM;


/**
 * Write a description of class Price here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Price
{
   public double rebate;
   public double price;
   public int discount;
    
  public Price(double price){
   this.price = price;
   this.discount = 0;
   this.rebate = 0;
  }

  public Price(double price , int discount){
    this.price = price;
    this.discount = discount;
    this.rebate = 0;

  }

  public Price(double price, double rebate){
    this.price = price;
    
  }

  public double getDiscountedPrice(int Discount){
    if (Discount == 100){
      return 0;
    }
    if (discount > 100){
      Discount = 100;
    }

    return price;
  }
}

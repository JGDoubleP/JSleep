package JeremyGandaPandapotanJSleepKM;

public class Room
{
   public int size;
   public String name;
   public Price price;
   public Facility facility;
   
   public Room(String name, int size, Price price, Facility facility){
      this.name = name;
      this.size = size;
      this.price = price;
      this.facility = facility;
   }
}

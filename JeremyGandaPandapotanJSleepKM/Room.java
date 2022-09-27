package JeremyGandaPandapotanJSleepKM;

/**
 * Write a description of class Serializable here.
 *
 * @author Jeremy Ganda Pandapotan
 * @version (a version number or a date)
 */
public class Room extends Serializable
{
   public int size;
   public String name;
   public Price price;
   public Facility facility;
   
   Room(int id, String name, int size, Price price, Facility facility){
      super(id);
      this.name = name;
      this.size = size;
      this.price = price;
      this.facility = facility;
   }
}

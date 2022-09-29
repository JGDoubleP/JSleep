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
   public BedType bedType ;
   public City city;
   public String address;
   
   Room(int id, String name, int size, Price price, Facility facility, City city,String address){
      super(id);
      this.name = name;
      this.size = size;
      this.price = price;
      this.facility = facility;
      this.city = city;
      this.address = address;
      this.bedType = BedType.SINGLE;
   }

   public String toString() {
      
       return "\nName: " + name + "\nSize: " + size  + "\nFacility: " + facility + "\nCity: " + city + "\naddress: " + address 
       + "\nBedtype: " + bedType;
   }
}

package JeremyGandaPandapotanJSleepKM;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

/**
 * Write a description of class JSleep here.
 *
 * @author Jeremy Ganda Pandapotan
 * 
 */

public class JSleep{
	public static void main(String args[]){
		Renter testRegex = new Renter("Netlab_", "081234567890", "Jl Margonda Raya");
		Renter testRegexFail = new Renter("netlab", "081", "Jalan");
		System.out.println(testRegex.validate());
		System.out.println(testRegexFail.validate());
		
		try {
			String filepath = "E:\\Kuligan\\Sem 3\\OOP\\Modul 1\\JSleep\\json\\randomRoomList.json";
			
			JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
			List<Room> filterTableRoom = filterByCity(tableRoom, "medan", 0, 5);
			filterTableRoom.forEach(room -> System.out.println(room.toString()));
		}
		catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	public static Room createRoom() {
		Price price = new Price(100000, 5);
        Room room = new Room(1, "JG" , 2, price, Facility.AC, City.JAKARTA, "Jl. Terus");
		return room;
	}
	
	public static List<Room> filterByCity (List<Room> list, String search, int page, int pageSize){
		
		return Algorithm.paginate(list, page, pageSize, room -> room.city.toString().toLowerCase().contains(search.toLowerCase()));
	}
	
	public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice){
		List<Room> Result = new ArrayList<Room>();
		
		return null;
	}
	
	public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
		return null;
	}
}



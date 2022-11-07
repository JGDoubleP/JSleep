package com.JeremyGandaPandapotanJSleepKM;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Write a description of class JSleep here.
 *
 * @author (Jeremy Ganda Pandapotan)
 * @version (7 November 2022)
 * 
 */

@SpringBootApplication
public class JSleep{
	public static void main(String args[]){
		SpringApplication.run(JSleep.class, args);
		Renter testRegex = new Renter("Netlab_", "081234567890", "Jl Margonda Raya");
		Renter testRegexFail = new Renter("netlab", "081", "Jalan");
		System.out.println(testRegex.validate());
		System.out.println(testRegexFail.validate());
		
		try {
			String filepath = "json/account.json";
			
			JsonTable <Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name", "email", "password"));
            tableAccount.writeJson();

            tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.forEach(account -> System.out.println(account.toString() + "\n"));
		}
		catch (Throwable t) {
			t.printStackTrace();
		}
		
		for(int i = 0; i < 10; i++) {
			ThreadingObject thread = new ThreadingObject("Thread " + i);
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
		return Algorithm.<Room>collect(list, room -> room.price.price >= minPrice && room.price.price <= maxPrice);
	}
	
	public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
		List<Room> result = new ArrayList<>();
        for (Room room : list)
        {
            if (room.accountId == accountId)
            {
                result.add(room);
            }
        }
        return result.subList(page * pageSize, Math.min((page + 1) * pageSize, result.size()));
	}
}
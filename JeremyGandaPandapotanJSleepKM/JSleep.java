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

public class JSleep
{
	class Country{
		public String name;
		public int population;
		public List<String> listOfStates;
	}
	
	public static void main (String[] args) {
		String filepath= "E:\\Kuligan\\Sem 3\\OOP\\Modul 1\\JSleep\\city.json";
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			Country input = gson.fromJson(br, Country.class);
			System.out.println("name: " + input.name);
			System.out.println("population: " + input.population);
			System.out.println("states : ");
			input.listOfStates.forEach(state -> System.out.println(state));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
    public static void main(String args[]){
        
    	ArrayList<Room> RoomSerialized = new ArrayList<Room>();
        
        for(int i = 0; i<5; i++){
            RoomSerialized.add(i, JSleep.createRoom());
            System.out.println(RoomSerialized.get(i).toString());
        }
    }

    public static Room createRoom(){
        Price price = new Price(100000, 5);
        Room room = new Room("JG" , 2, price, Facility.AC, City.JAKARTA, "Jl. Terus");

        return room;
    }
    */
}



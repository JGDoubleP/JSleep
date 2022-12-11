package com.JeremyGandaPandapotanJSleepKM.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JeremyGandaPandapotanJSleepKM.Account;
import com.JeremyGandaPandapotanJSleepKM.Algorithm;
import com.JeremyGandaPandapotanJSleepKM.BedType;
import com.JeremyGandaPandapotanJSleepKM.City;
import com.JeremyGandaPandapotanJSleepKM.Facility;
import com.JeremyGandaPandapotanJSleepKM.Price;
import com.JeremyGandaPandapotanJSleepKM.Room;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonAutowired;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonTable;

/**
 * This class is a REST controller for managing room resources. It provides methods
 * for handling HTTP requests for creating, reading, and getting rooms.
 */

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {
	/**
	 * A {@link JsonTable} containing a collection of rooms. This table is autowired with
	 * a JSON file at runtime.
	 */

	@JsonAutowired(filepath = "src/json/room.json", value = Room.class)
	public static JsonTable<Room> roomTable;

	/**
	 * Returns the {@link JsonTable} containing the collection of rooms.
	 * 
	 * @return The {@link JsonTable} containing the collection of rooms.
	 */

	@Override
	public JsonTable<Room> getJsonTable() {
		// TODO Auto-generated method stub
		return roomTable;
	}
	/**
	 * Returns a paginated list of rooms rented by a particular renter.
	 * 
	 * @param id The ID of the renter.
	 * @param page The page number of the paginated list.
	 * @param pageSize The page size of the paginated list.
	 * 
	 * @return A paginated list of rooms rented by the renter with the given ID.
	 */

	@GetMapping("/{id}/renter")
	List<Room> getRoomByRenter(
			@PathVariable int id,
			@RequestParam int page,
			@RequestParam int pageSize
			){
				return Algorithm.paginate(roomTable, page, pageSize, pred->pred.accountId == id);
	}
	
	/**
	 * Creates a new room and adds it to the collection of rooms.
	 * 
	 * @param accountId The ID of the account associated with the room.
	 * @param name The name of the room.
	 * @param size The size of the room.
	 * @param price The price of the room.
	 * @param facility The facilities offered by the room.
	 * @param bedType The type of bed in the room.
	 * @param city The city where the room is located.
	 * @param address The address of the room.
	 * 
	 * @return The newly created room.
	 */

	@PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam ArrayList<Facility> facility,
            @RequestParam BedType bedType,
            @RequestParam City city,
            @RequestParam String address
            ){
		Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
        if(account == null) return null;
        else{
            Room room = new Room(accountId, name, size, new Price(price), facility ,bedType , city, address);
            roomTable.add(room);
            return room;
        }	
	}
	
	/**
	 * Returns a paginated list of all rooms in the collection.
	 * 
	 * @param page The page number of the paginated list.
	 * @param pageSize The page size of the paginated list.
	 * 
	 * @return A paginated list of all rooms in the collection.
	 */

	@GetMapping("/getAllRoom")
    public List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        //return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> true);
		return Algorithm.paginate(RoomController.roomTable, page, pageSize, Objects::nonNull);
    }
	
}

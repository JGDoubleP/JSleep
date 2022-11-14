package com.JeremyGandaPandapotanJSleepKM.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JeremyGandaPandapotanJSleepKM.Algorithm;
import com.JeremyGandaPandapotanJSleepKM.City;
import com.JeremyGandaPandapotanJSleepKM.Facility;
import com.JeremyGandaPandapotanJSleepKM.Room;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonAutowired;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonTable;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {
	
	@JsonAutowired(filepath = "src/json/room.json", value = Room.class)
	public static JsonTable<Room> roomTable;

	@Override
	public JsonTable<Room> getJsonTable() {
		// TODO Auto-generated method stub
		return roomTable;
	}
	
	@PostMapping("/{id}/registerRenter")
	public List<Room> getRoomByRenter(
			@PathVariable int id,
			@RequestParam int page,
			@RequestParam int pageSize
			){
				return Algorithm.paginate(roomTable, page, pageSize, pred->pred.accountId == id);
	}
	
	@PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam Facility facility,
            @RequestParam City city,
            @RequestParam String address
            ){
        return null;
	
}
}

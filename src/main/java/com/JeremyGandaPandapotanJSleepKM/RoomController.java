package com.JeremyGandaPandapotanJSleepKM;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.JeremyGandaPandapotanJSleepKM.controller.BasicGetController;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonAutowired;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonTable;

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
				return null;
	}
	
	
	
}

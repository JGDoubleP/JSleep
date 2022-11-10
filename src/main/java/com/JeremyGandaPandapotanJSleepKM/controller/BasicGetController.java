package com.JeremyGandaPandapotanJSleepKM.controller;
import com.JeremyGandaPandapotanJSleepKM.Algorithm;
import com.JeremyGandaPandapotanJSleepKM.Predicate;
import com.JeremyGandaPandapotanJSleepKM.dbjson.*;
import java.util.*;
import org.springframework.web.bind.annotation.*;

public interface BasicGetController<T extends Serializable>{

	public abstract JsonTable<T> getJsonTable();
		@GetMapping("/page")
		
	
	public default List<T> getPage (
			@RequestParam int page,
			@RequestParam int pageSize
			){
			final JsonTable<T> table = getJsonTable();
			return Algorithm.paginate(table, page, pageSize, pred -> true);
		}
		
		 @GetMapping("/{id}")
	
	public default T getById(@PathVariable int id) {
		final Predicate<T> idFilter = pred-> (id == pred.id);
		return Algorithm.<T>find(getJsonTable(), e -> e.id == id);
	}
}

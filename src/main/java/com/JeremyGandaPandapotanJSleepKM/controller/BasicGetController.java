package com.JeremyGandaPandapotanJSleepKM.controller;
import com.JeremyGandaPandapotanJSleepKM.Algorithm;
import com.JeremyGandaPandapotanJSleepKM.Predicate;
import com.JeremyGandaPandapotanJSleepKM.dbjson.*;
import java.util.*;
import org.springframework.web.bind.annotation.*;

/**
 * This is an interface that provides basic GET functionality for a serializable object.
 *
 * @param <T> The type of serializable object that this controller operates on.
 */
public interface BasicGetController<T extends Serializable>{

	/**
     * Returns the JsonTable object that this controller operates on.
     *
     * @return The JsonTable object that this controller operates on.
     */
	public abstract JsonTable<T> getJsonTable();
		@GetMapping("/page")
		
		/**
	     * Returns a paginated list of objects from the JsonTable.
	     *
	     * @param page     The page number to return.
	     * @param pageSize The number of items to include in each page.
	     * @return A paginated list of objects from the JsonTable.
	     */
	public default List<T> getPage (
			@RequestParam int page,
			@RequestParam int pageSize
			){
			final JsonTable<T> table = getJsonTable();
			return Algorithm.paginate(table, page, pageSize, o -> true);
		}
		
		 @GetMapping("/{id}")
	
		 /**
		     * Returns an object from the JsonTable with the specified ID.
		     *
		     * @param id The ID of the object to return.
		     * @return The object from the JsonTable with the specified ID, or null if no such object exists.
		     */
	public default T getById(@PathVariable int id) {
		final Predicate<T> idFilter = pred-> (id == pred.id);
		return Algorithm.<T>find(getJsonTable(), e -> e.id == id);
	}
}

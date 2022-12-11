package com.JeremyGandaPandapotanJSleepKM.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.JeremyGandaPandapotanJSleepKM.Algorithm;
import com.JeremyGandaPandapotanJSleepKM.Price;
import com.JeremyGandaPandapotanJSleepKM.Voucher;
import com.JeremyGandaPandapotanJSleepKM.controller.BasicGetController;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonAutowired;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonTable;

/**
 * VoucherController provides RESTful APIs for managing vouchers.
 * 
 * @author JeremyGandaPandapotanJSleepKM
 * @version 1.0
 */
@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {

	/**
	 * The JsonTable containing the Voucher objects.
	 */
	@JsonAutowired(filepath = "src/json/voucher.json", value = Voucher.class)
	public static JsonTable<Voucher> voucherTable;
	
	/**
	 * Returns the JsonTable containing the Voucher objects.
	 * 
	 * @return the JsonTable containing the Voucher objects
	 */
	@Override
	@GetMapping("/voucher")
	public JsonTable<Voucher> getJsonTable() {
		// TODO Auto-generated method stub
		return voucherTable;
	}
	
	/**
	 * Returns whether the voucher with the given ID has been used.
	 * 
	 * @param id the ID of the voucher to check
	 * @return true if the voucher has been used, false otherwise
	 */
	@GetMapping("/{id}/isUsed")
	boolean isUsed(
			@PathVariable int id
			) {
		Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.isUsed();
	}
	
	/**
	 * Returns whether the voucher with the given ID can be applied to a purchase of the specified price.
	 * 
	 * @param id the ID of the voucher to check
	 * @param price the price of the purchase to check against
	 * @return true if the voucher can be applied, false otherwise
	 */
	@GetMapping("/{id}/canApply")
	boolean canApply(
			@PathVariable int id,
			@RequestParam double price
			) {
		Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.canApply(new Price(price));
		
	}
	
	/**
	 * Returns a paginated list of available (i.e. not used) vouchers.
	 * 
	 * @param page the page number to return
	 * @param pageSize the number of vouchers per page
	 * @return a list of available vouchers
	 */
	@GetMapping("/getAvailable")
    @ResponseBody
    List<Voucher> getAvailable(
			@RequestParam int page,
			@RequestParam int pageSize
			) {
		return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> !pred.isUsed());
	}

}

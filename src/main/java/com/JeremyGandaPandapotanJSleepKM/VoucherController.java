package com.JeremyGandaPandapotanJSleepKM;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.JeremyGandaPandapotanJSleepKM.controller.BasicGetController;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonAutowired;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonTable;

public class VoucherController implements BasicGetController<Voucher> {

	@JsonAutowired(filepath = "src/json/voucher.json", value = Voucher.class)
	public static JsonTable<Voucher> voucherTable;
	
	@Override
	@GetMapping("/voucher")
	public JsonTable<Voucher> getJsonTable() {
		// TODO Auto-generated method stub
		return voucherTable;
	}
	
	@PostMapping("/{id}/isUsed")
	boolean isUsed(
			@PathVariable int id
			) {
				return false;
	}
	
	@PostMapping("/{id}/canApply")
	boolean canApply(
			@PathVariable int id,
			@RequestParam double price
			) {
				return false;
		
	}
	
	@PostMapping("/getAvailable")
	boolean getAvailable(
			@PathVariable int page,
			@RequestParam double pageSize
			) {
				return false;
		
	}

}

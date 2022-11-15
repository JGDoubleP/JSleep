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

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {

	@JsonAutowired(filepath = "src/json/voucher.json", value = Voucher.class)
	public static JsonTable<Voucher> voucherTable;
	
	@Override
	@GetMapping("/voucher")
	public JsonTable<Voucher> getJsonTable() {
		// TODO Auto-generated method stub
		return voucherTable;
	}
	
	@GetMapping("/{id}/isUsed")
	boolean isUsed(
			@PathVariable int id
			) {
		Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.isUsed();
	}
	
	@GetMapping("/{id}/canApply")
	boolean canApply(
			@PathVariable int id,
			@RequestParam double price
			) {
		Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.canApply(new Price(price));
		
	}
	
	@GetMapping("/getAvailable")
    @ResponseBody
    List<Voucher> getAvailable(
			@RequestParam int page,
			@RequestParam int pageSize
			) {
		return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> !pred.isUsed());
	}

}

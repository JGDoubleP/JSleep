package com.JeremyGandaPandapotanJSleepKM.controller;

import com.JeremyGandaPandapotanJSleepKM.*;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonAutowired;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonTable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
	public static final String REGEX_EMAIL = "^\\w+@\\w+([\\.-]?\\w+)*.?\\w+$";
	public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)[a-zA-Z\\\\d]{8,}$";
	public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    
	
	@JsonAutowired(filepath = "src/json/account.json", value = Account.class)
	public static JsonTable<Account> accountTable;
	
	@GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    Account register( @RequestParam String name, @RequestParam String email, @RequestParam String password) {
        for (Account account : accountTable){
            if(account.email.equals(email) || (name.isBlank()) || account.validate()){
                return null;
            }
        }
        
        return new Account(name, email, password);
    }
    
    @PostMapping("/{id}/topUp")
    boolean topUp (
    		@RequestParam int id, 
    		@RequestParam double balance) {
        return false;
    }
    
    
    
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter (
    		@RequestParam int id, 
    		@RequestParam String username, 
    		@RequestParam  String address, 
    		@RequestParam String phoneNumber) {
        for (Account account : getJsonTable()) {
            if (account.id == id && account.renter == null) {
                Renter renter = new Renter (username, address, phoneNumber);
                account.renter = renter;
                return renter;
            }
        }
        return null;
        
    }
    

	@Override
	@GetMapping("/account")
	public JsonTable<Account> getJsonTable() {
		// TODO Auto-generated method stub
		return accountTable;
	}
	
	@PostMapping("/login")
    Account login( 
    		@RequestParam String email, 
    		@RequestParam String password) {
		
		try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString(bytes[i] & 0xff) + 0x100).substring(1);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
		
        for (Account account : accountTable) {
            if (account.email.equals(email) && account.password.equals(password)) {
                return account;
            }
        }
        return null;
    }

}

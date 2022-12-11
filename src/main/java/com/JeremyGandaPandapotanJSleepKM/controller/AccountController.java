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

/**
 * This class provides a REST controller for handling accounts.
 * It supports creating and querying accounts.
 * 
 * @author JeremyGandaPandapotanJSleepKM
 */

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
	public static final String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";
	public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)[a-zA-Z\\\\d]{8,}$";
	public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    
	
	@JsonAutowired(filepath = "src/json/account.json", value = Account.class)
	public static JsonTable<Account> accountTable;
	
	/**
	 * This method returns a string indicating the account page.
	 *
	 * @return A string indicating the account page.
	 */
	@GetMapping
    String index() { return "account page"; }

	/**
	 * This method registers a new account with the provided name, email, and password.
	 * It checks if the email and password are valid, hashes the password using MD5,
	 * and adds the new account to the account table.
	 *
	 * @param name The name of the new account.
	 * @param email The email of the new account.
	 * @param password The password of the new account.
	 * @return The new account if it was created successfully, or null otherwise.
	 */
	@PostMapping("/register")
    Account register( 
    		@RequestParam String name, 
    		@RequestParam String email, 
    		@RequestParam String password) {
		boolean findEmail = REGEX_PATTERN_EMAIL.matcher(email).find();
        boolean findPassword = REGEX_PATTERN_PASSWORD.matcher(password).find();
        try {
            MessageDigest msgDgst = MessageDigest.getInstance("MD5");
            msgDgst.update(password.getBytes());
            byte[] bytes = msgDgst.digest();
            StringBuilder strBuild = new StringBuilder();
            for (byte aByte : bytes) {
                strBuild.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            password = strBuild.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (findEmail || findPassword || !name.isBlank() && !accountTable.stream().anyMatch(account -> account.email.equals(email))) {
            Account account = new Account(name, email, password);
            accountTable.add(account);
            return account;
        }
        else{
            return null;
        }
	}
    
	/**
	 * This method registers a renter for the account with the provided id.
	 * It associates the renter with the account if the account exists and does not already have a renter.
	 *
	 * @param id The id of the account.
	 * @param username The username of the renter.
	 * @param address The address of the renter.
	 * @param phoneNumber The phone number of the renter.
	 * @return The new renter if it was registered successfully, or null otherwise.
	 */
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
    

    /**
     * This method returns the account table.
     *
     * @return The account table.
     */
	@Override
	@GetMapping("/account")
	public JsonTable<Account> getJsonTable() {
		// TODO Auto-generated method stub
		return accountTable;
	}
	
	/**
	 * This method logs in an existing account with the provided email and password.
	 * It checks if the email and password are valid, hashes the password using MD5,
	 * and returns the account if it exists in the account table.
	 *
	 * @param email The email of the existing account.
	 * @param password The password of the existing account.
	 * @return The existing account if the email and password are valid and the account exists, or null otherwise.
	 */
	@PostMapping("/login")
	Account login( @RequestParam String email, @RequestParam String password) {
		 try {
	            MessageDigest msgDgst = MessageDigest.getInstance("MD5");
	            msgDgst.update(password.getBytes());
	            byte[] bytes = msgDgst.digest();
	            StringBuilder strBuild = new StringBuilder();
	            int i = 0;
	            while (i < bytes.length) {
	                strBuild.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	                i++;
	            }
	            password = strBuild.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
        for (Account data : accountTable) {

            if (data.password.equals(password) && data.email.equals(email)) {
                return data;
            }
        }
        return null;
    }
	
	@PostMapping("{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance){
        Account account = Algorithm.<Account>find(getJsonTable(), pred -> pred.id == id);
        if(account == null) return false;
        account.balance += balance;
        return true;
    }

}

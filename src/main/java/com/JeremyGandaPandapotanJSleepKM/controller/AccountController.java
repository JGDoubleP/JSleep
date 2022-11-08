package com.JeremyGandaPandapotanJSleepKM.controller;

import com.JeremyGandaPandapotanJSleepKM.*;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonAutowired;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonTable;

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
    
	@JsonAutowired(filepath = "E:\\Kuligan\\Sem 3\\OOP\\Modul 1\\JSleep\\src\\json\\account.json", value = Account.class)
	public static JsonTable<Account> accountTable;
	
	@GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    public Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
    	Account newAccount = new Account (name, email, password, 0.0);
    	if ((!name.isBlank())) {
    		if (REGEX_PATTERN_EMAIL.matcher(email).matches() && REGEX_PATTERN_PASSWORD.matcher(password).matches()){
    			for (Account account : getJsonTable()) {
    				if(account.email.equals(email)) {
    					break;
    				}
    				accountTable.add(account);
    				return newAccount;
    			}
    		}
    	}
        return null;
    }

    
}

package com.JeremyGandaPandapotanJSleepKM;
import com.JeremyGandaPandapotanJSleepKM.dbjson.*;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Write a description of class JSleep here.
 *
 * @author (Jeremy Ganda Pandapotan)
 * @version (7 November 2022)
 * 
 */

@SpringBootApplication
public class JSleep{
	public static void main(String args[]){
		JsonDBEngine.Run(JSleep.class);
		SpringApplication.run(JSleep.class, args);
		Runtime.getRuntime().addShutdownHook(new Thread(()-> JsonDBEngine.join()));
	}
}
package com.JeremyGandaPandapotanJSleepKM;

import java.util.*;

/**
 * Write a description of class Serializable here.
 *
 * @author Jeremy Ganda Pandapotan
 * @version (a version number or a date)
 */
public class Serializable {
    public final int id;
    private static HashMap <Class<?>, Integer> mapCounter = new HashMap <Class<?>, Integer>();

    protected Serializable(){
    	int id;
        if(mapCounter.containsKey(this.getClass())) {
            id = mapCounter.get(this.getClass());
            id++;
         } else {
            id = 0;
        }
        this.id = id;
        mapCounter.put(this.getClass(), this.id);
    }
    
    public int compareTo(Serializable other) {
    	return ((Integer)this.id).compareTo(other.id);
    }
    
    public boolean equals (Object other) {
    	return (other instanceof Serializable && ((Serializable) other).id == this.id);
    }
    
    public boolean equals (Serializable other) {
    	return other.id == this.id;
    }
    
    public static <T> Integer getClosingId(Class<T> key) {
    	return mapCounter.get(key);
    }
    
    public static <T> Integer setClosingId(Class<T> key, int value) {
    	return mapCounter.replace(key, value);
    }
}

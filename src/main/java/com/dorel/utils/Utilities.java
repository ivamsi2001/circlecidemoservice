package com.dorel.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utilities {

	public static Logger log = LoggerFactory.getLogger(Utilities.class);
	public static String getSecurePassword(String passwordToHash, String salt)
	    {
	        String generatedPassword = null;
	        try {
	            // Create MessageDigest instance for MD5
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            //Add password bytes to digest
	            md.update(salt.getBytes());
	            //Get the hash's bytes
	            byte[] bytes = md.digest(passwordToHash.getBytes());
	            //This bytes[] has bytes in decimal format;
	            //Convert it to hexadecimal format
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            //Get complete hashed password in hex format
	            generatedPassword = sb.toString();
	        }
	        catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return generatedPassword;
	    }
	     
	
	
	public static int getRandomNumber(){
		
		 Random r = new Random();
		 int n = (int) (100000 + r.nextFloat() * 900000);
		return n;
	}
	 
}

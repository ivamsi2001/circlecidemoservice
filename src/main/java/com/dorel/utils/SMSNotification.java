/*
  * Copyright (c) *** - All Rights Reserved
  * Unauthorized copying of this file, via any medium is strictly prohibited
  * Proprietary and confidential
  * Written : Mallikarjun M
  */
package com.dorel.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SMSNotification {
	protected final static  Logger log = LoggerFactory.getLogger(SMSNotification.class);
	 public static void sendSms(String strIPAddress,String strUserName,String strPassword,String msisdn,String sid,String strMessage, String fl, String gwid,String smstype) throws IOException {
		 String data = "";
		 data += "user="+strUserName;
		 data += "&password="+strPassword;
				 data += "&msisdn="+msisdn;
				 data += "&sid="+sid; 
				 data += "&msg="+strMessage ;
				 data += "&fl="+fl ;
				 if("Transactional".equals(smstype)){
					 data += "&gwid="+gwid ;
				 }
				
				 
				 URL url = new
				 URL( strIPAddress + data);
				 log.info("strIPAddress + data.."+strIPAddress + data);
				 HttpURLConnection conn =	 (HttpURLConnection)url.openConnection();
				 conn.setRequestMethod("GET");
				 conn.setDoOutput(true);
				 conn.setDoInput(true);
				 conn.setUseCaches(false);
				 conn.connect();
				 BufferedReader rd = new BufferedReader(new
				 InputStreamReader(conn.getInputStream()));
				 String line;
				 StringBuffer buffer = new StringBuffer();
				 while ((line = rd.readLine()) != null){
				 buffer.append(line).append("\n");
				 }
				 log.info("sendSms status.."+buffer.toString());
				 rd.close();
				 conn.disconnect();
    }

}

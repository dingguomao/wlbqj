package com.bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ipLocation {
	
	public String getPlace(String ip) throws MalformedURLException {
		String url="https://apis.map.qq.com/ws/location/v1/ip?ip="+ip+"&key=PJSBZ-AM6CU-VACVB-2MXIB-K6QIZ-C5BG6";
		StringBuilder json = new StringBuilder();
		try {
		URL urlObject = new URL(url);
		URLConnection uc = urlObject.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"));
		String inputLine = null;
		while((inputLine = in.readLine()) != null) {
		json.append(inputLine);
		}
		in.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return json.toString();
			}
	
	public String getAddress(String json) {
		JSONObject object = JSON.parseObject(json);
		System.out.println(object);
		String status = object.get("status").toString();
		System.out.println(status);
		if (status.length()==1) {
			
		
		
		String nation = object.getJSONObject("result").getJSONObject("ad_info").get("nation").toString();
		String province = object.getJSONObject("result").getJSONObject("ad_info").get("province").toString();
		String city = object.getJSONObject("result").getJSONObject("ad_info").get("city").toString();
		String district = object.getJSONObject("result").getJSONObject("ad_info").get("district").toString();
		String result = nation + province + city + district;
		System.out.println(result);
		
		return result;
		}else {
			return "IP无法定位";
		}
		
	}
	
	
	
	
	}
	

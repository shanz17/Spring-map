package com.geolocation.maps.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geolocation.maps.model.LocatioModelDto;
import com.geolocation.maps.model.LocatioModelEntity;

import java.io.IOException;

import org.springframework.stereotype.Component;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class LocationService {
	
	
	OkHttpClient client = new OkHttpClient();

		public void test() {
			
		}
		
		public String calculate() throws IOException {
			String url="https://maps.googleapis.com/maps/api/distancematrix/json?origins=12.814917,79.712449&destinations=13.106667,80.079758&key=AIzaSyA8LFmIci-TKDWyV5Tg_LmSEKC41CHR1OY";
			            Request request = new Request.Builder()
			                .url(url)
			                .build();

			            Response response = client.newCall(request).execute();
			            
			            String jsonData = response.body().string();
			            JSONObject json = new JSONObject(jsonData);
			            org.json.JSONArray jsonArray = json.getJSONArray("rows");// json.get("rows");
			            JSONObject object1 = jsonArray.getJSONObject(0);
			            org.json.JSONArray jsonArray2 = object1.getJSONArray("elements");
			            JSONObject jsonObject = jsonArray2.getJSONObject(0);
			            //Get the Distance
			            JSONObject dist = jsonObject.getJSONObject("distance");
			            String distance = dist.getString("text");
			            //Get the time 
			            JSONObject tim = jsonObject.getJSONObject("duration");
			            String time = tim.getString("text");
			            
			            System.out.println("Time"  +time);
			            System.out.println("Distance" +distance);
			            //return response.body().string();
			            return null;
		}
		
		public LocatioModelDto calculateDistance(LocatioModelDto locationData) throws IOException {
			LocatioModelDto toSendList = new LocatioModelDto();
			List<LocatioModelEntity> sendPreferedLocation = new ArrayList<LocatioModelEntity>();
			LocatioModelEntity homeLocation = locationData.getHomeLocationData();
			List<LocatioModelEntity> preferLocaionList = locationData.getPreferedLocationData();
			Double homeLat = homeLocation.getLat();
			Double homeLng = homeLocation.getLng();
			if (!preferLocaionList.isEmpty()) {
				for (LocatioModelEntity locatioModelEntity : preferLocaionList) {
					Double lat = locatioModelEntity.getLat();
					Double lng = locatioModelEntity.getLng();
					String url="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+homeLat+","+homeLng+"&destinations="+lat+","+lng+"&key=AIzaSyA8LFmIci-TKDWyV5Tg_LmSEKC41CHR1OY";
		            Request request = new Request.Builder()
		                .url(url)
		                .build();
		            Response response = client.newCall(request).execute();
		            System.out.println("URL---" +url);
		            String jsonData = response.body().string();
		            System.out.println("Data---" +jsonData);
		            JSONObject json = new JSONObject(jsonData);
		            org.json.JSONArray jsonArray = json.getJSONArray("rows");// json.get("rows");
		            JSONObject object1 = jsonArray.getJSONObject(0);
		            org.json.JSONArray jsonArray2 = object1.getJSONArray("elements");
		            JSONObject jsonObject = jsonArray2.getJSONObject(0);
		            //Get the Distance
		            JSONObject dist = jsonObject.getJSONObject("distance");
		            String distance = dist.getString("text");
		            //Get the time 
		            JSONObject tim = jsonObject.getJSONObject("duration");
		            String time = tim.getString("text");
		            
		            locatioModelEntity.setLat(lat);
		            locatioModelEntity.setLng(lng);
		            locatioModelEntity.setPlaceName(locatioModelEntity.getPlaceName());
		            locatioModelEntity.setDistance(distance);
		            locatioModelEntity.setTime(time);
		            sendPreferedLocation.add(locatioModelEntity);
		            System.out.println("Time"  +time);
		            System.out.println("Distance" +distance);
				}
			}
			toSendList.setPreferedLocationData(preferLocaionList);
			toSendList.setHomeLocationData(homeLocation);
			
						    
			return toSendList;
		}
		
		
		
}

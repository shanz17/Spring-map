package com.geolocation.maps.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geolocation.maps.model.LocatioModelDto;
import com.geolocation.maps.model.LocatioModelEntity;
import com.geolocation.maps.service.LocationService;

@CrossOrigin(origins = "*", maxAge = 4200)
@RestController
@RequestMapping("/maps")
public class MapController {
	
	
	
	@Autowired
	private LocationService locationService;
	
	@CrossOrigin
	@PostMapping("/add")
	public LocatioModelDto add (@RequestBody LocatioModelDto locationData) {
		LocatioModelDto toSendList = new LocatioModelDto();
		
		try {
			toSendList = locationService.calculateDistance(locationData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//locationService.test();
		return  toSendList;
	}
	
	@GetMapping("/api")
	public String api() throws IOException {
		String calculate = locationService.calculate();
		System.out.println("Json" +calculate);
		return calculate;
	}
}

package com.geolocation.maps.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties
@JsonInclude(Include.NON_NULL)
public class LocatioModelEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String searchtext;
	
	private Double lat;
	
	private Double lng;
	
	private String IsValueSelectedFromAutoComplete;
	
	private String placeName;
	
	private String distance;
	
	private String time;
	
	public String getSearchtext() {
		return searchtext;
	}
	public void setSearchtext(String searchtext) {
		this.searchtext = searchtext;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public String getIsValueSelectedFromAutoComplete() {
		return IsValueSelectedFromAutoComplete;
	}
	public void setIsValueSelectedFromAutoComplete(String isValueSelectedFromAutoComplete) {
		IsValueSelectedFromAutoComplete = isValueSelectedFromAutoComplete;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "LocatioModelEntity [searchtext=" + searchtext + ", lat=" + lat + ", lng=" + lng
				+ ", IsValueSelectedFromAutoComplete=" + IsValueSelectedFromAutoComplete + ", placeName=" + placeName
				+ ", distance=" + distance + ", time=" + time + "]";
	}
	

}

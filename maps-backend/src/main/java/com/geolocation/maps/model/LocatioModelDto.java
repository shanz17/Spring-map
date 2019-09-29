package com.geolocation.maps.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties
@JsonInclude(Include.NON_NULL)
public class LocatioModelDto implements Serializable {

	private static final long serialVersionUID = -3360712028197508469L;
	
	private LocatioModelEntity homeLocationData;
	
	private List<LocatioModelEntity> preferedLocationData;

	public LocatioModelEntity getHomeLocationData() {
		return homeLocationData;
	}

	public void setHomeLocationData(LocatioModelEntity homeLocationData) {
		this.homeLocationData = homeLocationData;
	}

	public List<LocatioModelEntity> getPreferedLocationData() {
		return preferedLocationData;
	}

	public void setPreferedLocationData(List<LocatioModelEntity> preferedLocationData) {
		this.preferedLocationData = preferedLocationData;
	}
	
	@Override
	public String toString() {
		return "LocatioModelDto [homeLocationData=" + homeLocationData + ", preferedLocationData="
				+ preferedLocationData + "]";
	}


	

}

package ch.avendia.boatai.zsg.json;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class ZSGShip {

	@Expose
	private Double latitude;
	@Expose
	private Double longitude;
	@Expose
	private String speed;
	@Expose
	private Double delay;
	@Expose
	private String date;
	@Expose
	private String time;
	@Expose
	private Boolean active;
	@Expose
	private String kmh;

	/**
	* 
	* @return
	* The latitude
	*/
	public Double getLatitude() {
	return latitude;
	}

	/**
	* 
	* @param latitude
	* The latitude
	*/
	public void setLatitude(Double latitude) {
	this.latitude = latitude;
	}

	/**
	* 
	* @return
	* The longitude
	*/
	public Double getLongitude() {
	return longitude;
	}

	/**
	* 
	* @param longitude
	* The longitude
	*/
	public void setLongitude(Double longitude) {
	this.longitude = longitude;
	}

	/**
	* 
	* @return
	* The speed
	*/
	public String getSpeed() {
	return speed;
	}

	/**
	* 
	* @param speed
	* The speed
	*/
	public void setSpeed(String speed) {
	this.speed = speed;
	}

	/**
	* 
	* @return
	* The delay
	*/
	public Double getDelay() {
	return delay;
	}

	/**
	* 
	* @param delay
	* The delay
	*/
	public void setDelay(Double delay) {
	this.delay = delay;
	}

	/**
	* 
	* @return
	* The date
	*/
	public String getDate() {
	return date;
	}

	/**
	* 
	* @param date
	* The date
	*/
	public void setDate(String date) {
	this.date = date;
	}

	/**
	* 
	* @return
	* The time
	*/
	public String getTime() {
	return time;
	}

	/**
	* 
	* @param time
	* The time
	*/
	public void setTime(String time) {
	this.time = time;
	}

	/**
	* 
	* @return
	* The active
	*/
	public Boolean getActive() {
	return active;
	}

	/**
	* 
	* @param active
	* The active
	*/
	public void setActive(Boolean active) {
	this.active = active;
	}

	/**
	* 
	* @return
	* The kmh
	*/
	public String getKmh() {
	return kmh;
	}

	/**
	* 
	* @param kmh
	* The kmh
	*/
	public void setKmh(String kmh) {
	this.kmh = kmh;
	}
	
}

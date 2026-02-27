package com.howard.hbase.util;

import java.io.Serializable;

public class Aitrackp implements Serializable{
	
	private String vehicleId;
	
	private double lon;
	
	private double lat;
	
	private String gpstime;
	
	private String createdTime;
	
	private String wid;
	
	private String transfer;
	
	private String direction;
	
	private String accStatus;
	
	private String lineStatus;
	
	private String loStatus;
	
	private String status;
	
	private String speed;
	
	private String odometer;
	
	private String geo;

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getGpstime() {
		return gpstime;
	}

	public void setGpstime(String gpstime) {
		this.gpstime = gpstime;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getTransfer() {
		return transfer;
	}

	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public String getLineStatus() {
		return lineStatus;
	}

	public void setLineStatus(String lineStatus) {
		this.lineStatus = lineStatus;
	}

	public String getLoStatus() {
		return loStatus;
	}

	public void setLoStatus(String loStatus) {
		this.loStatus = loStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public String getOdometer() {
		return odometer;
	}

	public void setOdometer(String odometer) {
		this.odometer = odometer;
	}

	@Override
	public String toString() {
		return "Aitrackp [vehicleId=" + vehicleId + ", lon=" + lon + ", lat="
				+ lat + ", gpstime=" + gpstime + ", createdTime=" + createdTime
				+ ", wid=" + wid + ", transfer=" + transfer + ", direction="
				+ direction + ", accStatus=" + accStatus + ", lineStatus="
				+ lineStatus + ", loStatus=" + loStatus + ", status=" + status
				+ ", speed=" + speed + ", odometer=" + odometer + ", geo="
				+ geo + "]";
	}
	
	

}

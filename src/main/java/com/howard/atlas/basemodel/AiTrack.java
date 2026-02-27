
 /**   
 * Copyright © 2017 e6gps. All rights reserved.
 * @version: V1.0   
 */
 
package com.howard.atlas.basemodel;

import java.io.Serializable;
import java.math.BigDecimal;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

 /**
 * 数据总线：轨迹对象
 * Created by wanggaoli@e6yun.com on 2017年4月5日 下午6:57:55. 
 */
public class AiTrack implements Serializable {
	/**
	 * 车辆ID
	 */
	@JSONField(name = "VehicleID",ordinal = 0)
	private Integer vehicleID;
	/**
	 * 定位时间。东八区
	 */
	@JSONField(name = "GpsTime",ordinal = 1)
	private Long gpsTime;
	/**
	 * 中心识别码
	 */
	@JSONField(name = "Wid",ordinal = 2)
	private String wid;
	/**
	 * 经度
	 */
	@JSONField(name = "Lon",ordinal = 3)
	private BigDecimal lon;
	/**
	 * 纬度
	 */
	@JSONField(name = "Lat",ordinal = 4)
	private BigDecimal lat;
	/**
	 * 速度
	 */
	@JSONField(name = "Speed",ordinal = 5)
	private Integer speed;
	/**
	 * 方向
	 */
	@JSONField(name = "Direction",ordinal = 6)
	private Integer direction;
	/**
	 * 里程，最多有7位整数
	 */
	@JSONField(name = "Odometer",ordinal = 7)
	private BigDecimal odometer;
	/**
	 * 高度
	 */
	@JSONField(name = "Height",ordinal = 8)
	private Integer height;
	/**
	 * ACC状态;0 无,1关,2开
	 */
	@JSONField(name = "ACCStatus",ordinal = 9)
	private Integer aCCStatus;
	/**
	 * 天线状态;0无,1天线正常，2天线断开，3天线短路,4天线状态异常
	 */
	@JSONField(name = "LineStatus",ordinal = 10)
	private Integer lineStatus;
	/**
	 * 定位状态;0 无,1 1D,2 2D ,3 3D
	 */
	@JSONField(name = "LoStatus",ordinal = 11)
	private Integer loStatus;
	/**
	 * 状态字符串，排除ACC、Line、Lo
	 */
	@JSONField(name = "Status",ordinal = 12)
	private String status;
	/**
	 * 数据写入时间
	 */
	@JSONField(name = "UpdateLong",ordinal = 13)
	private Long updateLong;
	/**
	 * 数据终端ID
	 */
	@JSONField(name = "DataTerminalID",ordinal = 14)
	private Integer dataTerminalID;
	/**
	 * 基站信息
	 */
	@JSONField(name = "Station",ordinal = 15)
	private String station;
	/**
	 * 数据源 0 GPS定位 1 基站定位  默认是0
	 */
	@JSONField(name = "DataSourceID",ordinal = 16)
	private Integer dataSourceID;
	/**
	 * 设备来源，同E3配置表
	 */
	@JSONField(name = "EqSourceID",ordinal = 17)
	private Integer eqSourceID;
	
	
	public AiTrack(){}
	public AiTrack(JSONObject aiTrack){
		if(aiTrack == null){
			return;
		}
		setVehicleID(aiTrack.getInteger("VehicleID"));
		setGpsTime(aiTrack.getLong("GpsTime"));
		setWid(aiTrack.getString("Wid"));
		setLon(aiTrack.getBigDecimal("Lon"));
		setLat(aiTrack.getBigDecimal("Lat"));
		setSpeed(aiTrack.getInteger("Speed"));
		setDirection(aiTrack.getInteger("Direction"));
		setOdometer(aiTrack.getBigDecimal("Odometer"));
		setHeight(aiTrack.getInteger("Height"));
		setACCStatus(aiTrack.getInteger("ACCStatus"));
		setLineStatus(aiTrack.getInteger("LineStatus"));
		setLoStatus(aiTrack.getInteger("LoStatus"));
		setStatus(aiTrack.getString("Status"));
		setUpdateLong(aiTrack.getLong("UpdateLong"));
		setDataTerminalID(aiTrack.getInteger("DataTerminalID"));
		setStation(aiTrack.getString("Station"));
		setDataSourceID(aiTrack.getInteger("DataSourceID"));
		setEqSourceID(aiTrack.getInteger("EqSourceID"));
	}
	
	
	/**
	 * @return the vehicleID
	 */
	public Integer getVehicleID() {
		return vehicleID;
	}
	/**
	 * @param vehicleID the vehicleID to set
	 */
	public void setVehicleID(Integer vehicleID) {
		this.vehicleID = vehicleID;
	}
	/**
	 * @return the gpsTime
	 */
	public Long getGpsTime() {
		return gpsTime;
	}
	/**
	 * @param gpsTime the gpsTime to set
	 */
	public void setGpsTime(Long gpsTime) {
		this.gpsTime = gpsTime;
	}
	/**
	 * @return the wid
	 */
	public String getWid() {
		return wid;
	}
	/**
	 * @param wid the wid to set
	 */
	public void setWid(String wid) {
		this.wid = wid;
	}
	/**
	 * @return the lon
	 */
	public BigDecimal getLon() {
		return lon;
	}
	/**
	 * @param lon the lon to set
	 */
	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}
	/**
	 * @return the lat
	 */
	public BigDecimal getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	/**
	 * @return the speed
	 */
	public Integer getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	/**
	 * @return the direction
	 */
	public Integer getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	/**
	 * @return the odometer
	 */
	public BigDecimal getOdometer() {
		return odometer;
	}
	/**
	 * @param odometer the odometer to set
	 */
	public void setOdometer(BigDecimal odometer) {
		this.odometer = odometer;
	}
	/**
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}
	/**
	 * @return the aCCStatus
	 */
	public Integer getACCStatus() {
		return aCCStatus;
	}
	/**
	 * @param aCCStatus the aCCStatus to set
	 */
	public void setACCStatus(Integer aCCStatus) {
		this.aCCStatus = aCCStatus;
	}
	/**
	 * @return the lineStatus
	 */
	public Integer getLineStatus() {
		return lineStatus;
	}
	/**
	 * @param lineStatus the lineStatus to set
	 */
	public void setLineStatus(Integer lineStatus) {
		this.lineStatus = lineStatus;
	}
	/**
	 * @return the loStatus
	 */
	public Integer getLoStatus() {
		return loStatus;
	}
	/**
	 * @param loStatus the loStatus to set
	 */
	public void setLoStatus(Integer loStatus) {
		this.loStatus = loStatus;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the updateLong
	 */
	public Long getUpdateLong() {
		return updateLong;
	}
	/**
	 * @param updateLong the updateLong to set
	 */
	public void setUpdateLong(Long updateLong) {
		this.updateLong = updateLong;
	}
	/**
	 * @return the dataTerminalID
	 */
	public Integer getDataTerminalID() {
		return dataTerminalID;
	}
	/**
	 * @param dataTerminalID the dataTerminalID to set
	 */
	public void setDataTerminalID(Integer dataTerminalID) {
		this.dataTerminalID = dataTerminalID;
	}
	/**
	 * @return the station
	 */
	public String getStation() {
		return station;
	}
	/**
	 * @param station the station to set
	 */
	public void setStation(String station) {
		this.station = station;
	}
	/**
	 * @return the dataSourceID
	 */
	public Integer getDataSourceID() {
		return dataSourceID;
	}
	/**
	 * @param dataSourceID the dataSourceID to set
	 */
	public void setDataSourceID(Integer dataSourceID) {
		this.dataSourceID = dataSourceID;
	}
	/**
	 * @return the eqSourceID
	 */
	public Integer getEqSourceID() {
		return eqSourceID;
	}
	/**
	 * @param eqSourceID the eqSourceID to set
	 */
	public void setEqSourceID(Integer eqSourceID) {
		this.eqSourceID = eqSourceID;
	}
	
	

}

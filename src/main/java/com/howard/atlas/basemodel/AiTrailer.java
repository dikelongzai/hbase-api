
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
 * 甩挂
 * Created by wanggaoli@e6yun.com on 2017年4月5日 下午6:59:04. 
 */
public class AiTrailer implements Serializable {

	/**
	 * 标签ID
	 */
	@JSONField(name = "RFID",ordinal = 0)
	private String rFID;
	/**
	 * 电压
	 */
	@JSONField(name = "Voltage",ordinal = 1)
	private BigDecimal voltage;
	/**
	 * 甩挂类型 1：无线 2：有线
	 */
	@JSONField(name = "TrailerType",ordinal = 2)
	private Integer trailerType;
	
	public AiTrailer(){}
	public AiTrailer(JSONObject aiTrailer){
		if(aiTrailer == null){
			return;
		}
		setRFID(aiTrailer.getString("RFID"));
		setVoltage(aiTrailer.getBigDecimal("Voltage"));
		setTrailerType(aiTrailer.getInteger("TrailerType"));
	}
	
	/**
	 * @return the rFID
	 */
	public String getRFID() {
		return rFID;
	}
	/**
	 * @param rFID the rFID to set
	 */
	public void setRFID(String rFID) {
		this.rFID = rFID;
	}
	/**
	 * @return the voltage
	 */
	public BigDecimal getVoltage() {
		return voltage;
	}
	/**
	 * @param voltage the voltage to set
	 */
	public void setVoltage(BigDecimal voltage) {
		this.voltage = voltage;
	}
	/**
	 * @return the trailerType
	 */
	public Integer getTrailerType() {
		return trailerType;
	}
	/**
	 * @param trailerType the trailerType to set
	 */
	public void setTrailerType(Integer trailerType) {
		this.trailerType = trailerType;
	}
	
	

}


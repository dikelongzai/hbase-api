
 /**   
 * Copyright © 2017 e6gps. All rights reserved.
 * @version: V1.0   
 */
 
package com.howard.atlas.basemodel;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

 /**
 * 停车
 * Created by wanggaoli@e6yun.com on 2017年4月5日 下午6:58:25. 
 */
public class AiStopTime implements Serializable {
	 /**
	 * 时长，秒
	 */
	@JSONField(name = "StopSecs",ordinal = 0)
	private Integer stopSecs;
	/**
	 * 类型，48停车、49停车未熄火
	 */
	@JSONField(name = "TheType",ordinal = 1)
	private Integer theType;
	/**
	 * 停车开始标志,1为停车开始，2为停车结束
	 */
	@JSONField(name = "StopBegin",ordinal = 2)
	private Integer stopBegin;
	/**
	 * 停车流水号
	 */
	@JSONField(name = "SSN",ordinal = 3)
	private Integer sSN;
	
	public AiStopTime(){}
	public AiStopTime(JSONObject aiStopTime){
		if(aiStopTime == null){
			return;
		}
		setStopSecs(aiStopTime.getInteger("StopSecs"));
		setTheType(aiStopTime.getInteger("TheType"));
		setStopBegin(aiStopTime.getInteger("StopBegin"));
		setSSN(aiStopTime.getInteger("SSN"));
	}
	
	/**
	 * @return the stopSecs
	 */
	public Integer getStopSecs() {
		return stopSecs;
	}
	/**
	 * @param stopSecs the stopSecs to set
	 */
	public void setStopSecs(Integer stopSecs) {
		this.stopSecs = stopSecs;
	}
	/**
	 * @return the theType
	 */
	public Integer getTheType() {
		return theType;
	}
	/**
	 * @param theType the theType to set
	 */
	public void setTheType(Integer theType) {
		this.theType = theType;
	}
	/**
	 * @return the stopBegin
	 */
	public Integer getStopBegin() {
		return stopBegin;
	}
	/**
	 * @param stopBegin the stopBegin to set
	 */
	public void setStopBegin(Integer stopBegin) {
		this.stopBegin = stopBegin;
	}
	/**
	 * @return the sSN
	 */
	public Integer getSSN() {
		return sSN;
	}
	/**
	 * @param sSN the sSN to set
	 */
	public void setSSN(Integer sSN) {
		this.sSN = sSN;
	}
	
	

}

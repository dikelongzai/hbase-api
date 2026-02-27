
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
 * 温度
 * Created by wanggaoli@e6yun.com on 2017年4月5日 下午6:58:45. 
 */
public class AiTemp implements Serializable {

	 @JSONField(name = "T1",ordinal = 0)
	private BigDecimal t1;
	 @JSONField(name = "T2",ordinal = 1)
	private BigDecimal t2;
	 @JSONField(name = "T3",ordinal = 2)
	private BigDecimal t3;
	 @JSONField(name = "T4",ordinal = 3)
	private BigDecimal t4;
	 @JSONField(name = "T1Time",ordinal = 4)
	private Long t1Time;
	 @JSONField(name = "T2Time",ordinal = 5)
	private Long t2Time;
	 @JSONField(name = "T3Time",ordinal = 6)
	private Long t3Time;
	 @JSONField(name = "T4Time",ordinal = 7)
	private Long t4Time;
	 @JSONField(name = "ColdStatus",ordinal = 8)
	private Integer coldStatus;
	
	public AiTemp(){}
	public AiTemp(JSONObject aiTemp){
		if(aiTemp == null){
			return;
		}
		setT1(aiTemp.getBigDecimal("T1"));
		setT2(aiTemp.getBigDecimal("T2"));
		setT3(aiTemp.getBigDecimal("T3"));
		setT4(aiTemp.getBigDecimal("T4"));
		setT1Time(aiTemp.getLong("T1Time"));
		setT2Time(aiTemp.getLong("T2Time"));
		setT3Time(aiTemp.getLong("T3Time"));
		setT4Time(aiTemp.getLong("T4Time"));
	}
	
	/**
	 * @return the t1
	 */
	public BigDecimal getT1() {
		return t1;
	}
	/**
	 * @param t1 the t1 to set
	 */
	public void setT1(BigDecimal t1) {
		this.t1 = t1;
	}
	/**
	 * @return the t2
	 */
	public BigDecimal getT2() {
		return t2;
	}
	/**
	 * @param t2 the t2 to set
	 */
	public void setT2(BigDecimal t2) {
		this.t2 = t2;
	}
	/**
	 * @return the t3
	 */
	public BigDecimal getT3() {
		return t3;
	}
	/**
	 * @param t3 the t3 to set
	 */
	public void setT3(BigDecimal t3) {
		this.t3 = t3;
	}
	/**
	 * @return the t4
	 */
	public BigDecimal getT4() {
		return t4;
	}
	/**
	 * @param t4 the t4 to set
	 */
	public void setT4(BigDecimal t4) {
		this.t4 = t4;
	}
	/**
	 * @return the t1Time
	 */
	public Long getT1Time() {
		return t1Time;
	}
	/**
	 * @param t1Time the t1Time to set
	 */
	public void setT1Time(Long t1Time) {
		this.t1Time = t1Time;
	}
	/**
	 * @return the t2Time
	 */
	public Long getT2Time() {
		return t2Time;
	}
	/**
	 * @param t2Time the t2Time to set
	 */
	public void setT2Time(Long t2Time) {
		this.t2Time = t2Time;
	}
	/**
	 * @return the t3Time
	 */
	public Long getT3Time() {
		return t3Time;
	}
	/**
	 * @param t3Time the t3Time to set
	 */
	public void setT3Time(Long t3Time) {
		this.t3Time = t3Time;
	}
	/**
	 * @return the t4Time
	 */
	public Long getT4Time() {
		return t4Time;
	}
	/**
	 * @param t4Time the t4Time to set
	 */
	public void setT4Time(Long t4Time) {
		this.t4Time = t4Time;
	}
	/**
	 * @return the coldStatus
	 */
	public Integer getColdStatus() {
		return coldStatus;
	}
	/**
	 * @param coldStatus the coldStatus to set
	 */
	public void setColdStatus(Integer coldStatus) {
		this.coldStatus = coldStatus;
	}
	
	

}

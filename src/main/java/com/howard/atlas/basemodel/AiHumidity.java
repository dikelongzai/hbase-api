
 /**   
 * Copyright © 2017 e6gps. All rights reserved.
 * @version: V1.0   
 */
 
package com.howard.atlas.basemodel;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

 /**
 * 湿度
 * Created by wanggaoli@e6yun.com on 2017年4月5日 下午6:59:23. 
 */
public class AiHumidity  implements Serializable {

	 @JSONField(name = "H1",ordinal = 0)
	private Integer h1;
	 @JSONField(name = "H2",ordinal = 1)
	private Integer h2;
	 @JSONField(name = "H3",ordinal = 2)
	private Integer h3;
	 @JSONField(name = "H4",ordinal = 3)
	private Integer h4;
	 @JSONField(name = "H1Time",ordinal = 4)
	private Long h1Time;
	 @JSONField(name = "H2Time",ordinal = 5)
	private Long h2Time;
	 @JSONField(name = "H3Time",ordinal = 6)
	private Long h3Time;
	 @JSONField(name = "H4Time",ordinal = 7)
	private Long h4Time;
	
	public AiHumidity(){}
	public AiHumidity(JSONObject aiHumidity){
		if(aiHumidity == null){
			return;
		}
		setH1(aiHumidity.getInteger("H1"));
		setH2(aiHumidity.getInteger("H2"));
		setH3(aiHumidity.getInteger("H3"));
		setH4(aiHumidity.getInteger("H4"));
		setH1Time(aiHumidity.getLong("H1Time"));
		setH2Time(aiHumidity.getLong("H2Time"));
		setH3Time(aiHumidity.getLong("H3Time"));
		setH4Time(aiHumidity.getLong("H4Time"));
	}
	
	/**
	 * @return the h1
	 */
	public Integer getH1() {
		return h1;
	}
	/**
	 * @param h1 the h1 to set
	 */
	public void setH1(Integer h1) {
		this.h1 = h1;
	}
	/**
	 * @return the h2
	 */
	public Integer getH2() {
		return h2;
	}
	/**
	 * @param h2 the h2 to set
	 */
	public void setH2(Integer h2) {
		this.h2 = h2;
	}
	/**
	 * @return the h3
	 */
	public Integer getH3() {
		return h3;
	}
	/**
	 * @param h3 the h3 to set
	 */
	public void setH3(Integer h3) {
		this.h3 = h3;
	}
	/**
	 * @return the h4
	 */
	public Integer getH4() {
		return h4;
	}
	/**
	 * @param h4 the h4 to set
	 */
	public void setH4(Integer h4) {
		this.h4 = h4;
	}
	/**
	 * @return the h1Time
	 */
	public Long getH1Time() {
		return h1Time;
	}
	/**
	 * @param h1Time the h1Time to set
	 */
	public void setH1Time(Long h1Time) {
		this.h1Time = h1Time;
	}
	/**
	 * @return the h2Time
	 */
	public Long getH2Time() {
		return h2Time;
	}
	/**
	 * @param h2Time the h2Time to set
	 */
	public void setH2Time(Long h2Time) {
		this.h2Time = h2Time;
	}
	/**
	 * @return the h3Time
	 */
	public Long getH3Time() {
		return h3Time;
	}
	/**
	 * @param h3Time the h3Time to set
	 */
	public void setH3Time(Long h3Time) {
		this.h3Time = h3Time;
	}
	/**
	 * @return the h4Time
	 */
	public Long getH4Time() {
		return h4Time;
	}
	/**
	 * @param h4Time the h4Time to set
	 */
	public void setH4Time(Long h4Time) {
		this.h4Time = h4Time;
	}



}

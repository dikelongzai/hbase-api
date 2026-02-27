
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
 * 油量
 * Created by wanggaoli@e6yun.com on 2017年4月5日 下午6:58:34. 
 */
public class AiOil implements Serializable {

	/**
	 * 油量1
	 */
	@JSONField(name = "OilCalc",ordinal = 0)
	private BigDecimal oilCalc;
	/**
	 * 油量2
	 */
	@JSONField(name = "OilCalc2",ordinal = 1)
	private BigDecimal oilCalc2;
	/**
	 * 油箱个数
	 */
	@JSONField(name = "OilBoxNumber",ordinal = 2)
	private Integer oilBoxNumber;
	
	public AiOil(){}
	public AiOil(JSONObject aiOil){
		if(aiOil == null){
			return;
		}
		setOilCalc(aiOil.getBigDecimal("OilCalc"));
		setOilCalc2(aiOil.getBigDecimal("OilCalc2"));
		setOilBoxNumber(aiOil.getInteger("OilBoxNumber"));
		
	}
	
	/**
	 * @return the oilCalc
	 */
	public BigDecimal getOilCalc() {
		return oilCalc;
	}
	/**
	 * @param oilCalc the oilCalc to set
	 */
	public void setOilCalc(BigDecimal oilCalc) {
		this.oilCalc = oilCalc;
	}
	/**
	 * @return the oilCalc2
	 */
	public BigDecimal getOilCalc2() {
		return oilCalc2;
	}
	/**
	 * @param oilCalc2 the oilCalc2 to set
	 */
	public void setOilCalc2(BigDecimal oilCalc2) {
		this.oilCalc2 = oilCalc2;
	}
	/**
	 * @return the oilBoxNumber
	 */
	public Integer getOilBoxNumber() {
		return oilBoxNumber;
	}
	/**
	 * @param oilBoxNumber the oilBoxNumber to set
	 */
	public void setOilBoxNumber(Integer oilBoxNumber) {
		this.oilBoxNumber = oilBoxNumber;
	}
	
	
}


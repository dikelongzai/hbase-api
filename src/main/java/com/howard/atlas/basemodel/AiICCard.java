
 /**   
 * Copyright © 2017 e6gps. All rights reserved.
 * @version: V1.0   
 */
 
package com.howard.atlas.basemodel;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

 /**
 * IC卡
 * Created by wanggaoli@e6yun.com on 2017年4月5日 下午6:58:54. 
 */
public class AiICCard implements Serializable {

	/**
	 * IC卡编号
	 */
	@JSONField(name = "ICNO",ordinal = 0)
	private Integer iCNO;
	/**
	 * 0插卡,1拔卡,非接触式的给-1
	 */
	@JSONField(name = "StatusType",ordinal = 1)
	private Integer statusType;
	/**
	 * 1非接触式的 2接触式的
	 */
	@JSONField(name = "CardType",ordinal = 2)
	private Integer cardType;
	
	public AiICCard(){}
	public AiICCard(JSONObject aiICCard){
		if(aiICCard == null){
			return;
		}
		setICNO(aiICCard.getInteger("ICNO"));
		setStatusType(aiICCard.getInteger("StatusType"));
		setCardType(aiICCard.getInteger("CardType"));
	}
	
	/**
	 * @return the iCNO
	 */
	public Integer getICNO() {
		return iCNO;
	}
	
	/**
	 * @param iCNO the iCNO to set
	 */
	public void setICNO(Integer iCNO) {
		this.iCNO = iCNO;
	}
	/**
	 * @return the statusType
	 */
	public Integer getStatusType() {
		return statusType;
	}
	/**
	 * @param statusType the statusType to set
	 */
	public void setStatusType(Integer statusType) {
		this.statusType = statusType;
	}
	/**
	 * @return the cardType
	 */
	public Integer getCardType() {
		return cardType;
	}
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}




}

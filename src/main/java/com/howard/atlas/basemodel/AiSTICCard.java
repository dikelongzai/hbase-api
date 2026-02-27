
 /**   
 * Copyright © 2017 e6gps. All rights reserved.
 * @version: V1.0   
 */
 
package com.howard.atlas.basemodel;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

 /**
 * 部标标准IC卡
 * Created by wanggaoli@e6yun.com on 2017年4月5日 下午6:59:15. 
 */
public class AiSTICCard implements Serializable {




	/**
	 * 打卡状态。1表示插卡，2表示拔卡
	 */
	@JSONField(name = "StatusType",ordinal = 0)
	private Integer statusType;
	/**
	 * IC卡读取结果。0表示读卡成功，1~4表示读卡失败
	 */
	@JSONField(name = "ReadResult",ordinal = 1)
	private Integer readResult;
	/**
	 * 司机姓名
	 */
	@JSONField(name = "DriverName",ordinal = 2)
	private String driverName;
	/**
	 * 从业资格证编码
	 */
	@JSONField(name = "DQCN",ordinal = 3)
	private String dQCN;
	/**
	 * 发证机构名称
	 */
	@JSONField(name = "CIAN",ordinal = 4)
	private String cIAN;
	/**
	 * 证件有效期
	 */
	@JSONField(name = "ExpireTime",ordinal = 5)
	private Long expireTime;
	/**
	 * 卡数字签名
	 */
	@JSONField(name = "DigitalSign",ordinal = 6)
	private String digitalSign;
	
	public AiSTICCard(){}
	public AiSTICCard(JSONObject aiSTICCard){
		if(aiSTICCard == null){
			return;
		}
		setStatusType(aiSTICCard.getInteger("StatusType"));
		setReadResult(aiSTICCard.getInteger("ReadResult"));
		setDriverName(aiSTICCard.getString("DriverName"));
		setDQCN(aiSTICCard.getString("DQCN"));
		setCIAN(aiSTICCard.getString("CIAN"));
		setExpireTime(aiSTICCard.getLong("ExpireTime"));
		setDigitalSign(aiSTICCard.getString("DigitalSign"));
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
	 * @return the readResult
	 */
	public Integer getReadResult() {
		return readResult;
	}
	/**
	 * @param readResult the readResult to set
	 */
	public void setReadResult(Integer readResult) {
		this.readResult = readResult;
	}
	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}
	/**
	 * @param driverName the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	/**
	 * @return the dQCN
	 */
	public String getDQCN() {
		return dQCN;
	}
	/**
	 * @param dQCN the dQCN to set
	 */
	public void setDQCN(String dQCN) {
		this.dQCN = dQCN;
	}
	/**
	 * @return the cIAN
	 */
	public String getCIAN() {
		return cIAN;
	}
	/**
	 * @param cIAN the cIAN to set
	 */
	public void setCIAN(String cIAN) {
		this.cIAN = cIAN;
	}
	/**
	 * @return the expireTime
	 */
	public Long getExpireTime() {
		return expireTime;
	}
	/**
	 * @param expireTime the expireTime to set
	 */
	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}
	/**
	 * @return the digitalSign
	 */
	public String getDigitalSign() {
		return digitalSign;
	}
	/**
	 * @param digitalSign the digitalSign to set
	 */
	public void setDigitalSign(String digitalSign) {
		this.digitalSign = digitalSign;
	}
	
	
}

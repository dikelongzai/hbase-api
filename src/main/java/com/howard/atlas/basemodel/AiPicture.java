
/**
 * Copyright © 2017 e6gps. All rights reserved.
 *
 * @version: V1.0
 */

package com.howard.atlas.basemodel;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 照片数据
 * Created by wanggaoli@e6yun.com on 2017年4月6日 上午7:50:43.
 */
public class AiPicture implements Serializable {
    /**
     * 图片的二字节码数据
     */
    @JSONField(name = "PicData",ordinal = 0)
    private byte[] picData;
    /**
     * 图片名称
     */
    @JSONField(name = "FileName",ordinal = 1)
    private String fileName;
    /**
     * 摄像路数
     */
    @JSONField(name = "CamID",ordinal = 2)
    private Integer camID;
    /**
     * 拍照类型
     */
    @JSONField(name = "CameraTypeID",ordinal = 3)
    private Integer cameraTypeID;
    /**
     * 照片回码
     */
    @JSONField(name = "PhotoBackCode",ordinal = 4)
    private Integer photoBackCode;
    /**
     * 拍照时间
     */
    @JSONField(name = "PicTime",ordinal = 5)
    private Long picTime;
    /**
     * 图片上传到oss服务器上返回的url地址
     */
    @JSONField(name = "Url",ordinal = 6)
    private String url;

    public AiPicture(){}
    public AiPicture(JSONObject aiPicture){
        if(aiPicture == null){
            return;
        }
        setFileName(aiPicture.getString("FileName"));
        setCamID(aiPicture.getInteger("CamID"));
        setCameraTypeID(aiPicture.getInteger("CameraTypeID"));
        setPhotoBackCode(aiPicture.getInteger("PhotoBackCode"));
        setPicTime(aiPicture.getLong("PicTime"));
        setUrl(aiPicture.getString("Url"));
    }

    public byte[] getPicData() {
        return picData;
    }

    public void setPicData(byte[] picData) {
        this.picData = picData;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getCamID() {
        return camID;
    }

    public void setCamID(Integer camID) {
        this.camID = camID;
    }

    public Integer getCameraTypeID() {
        return cameraTypeID;
    }

    public void setCameraTypeID(Integer cameraTypeID) {
        this.cameraTypeID = cameraTypeID;
    }

    public Integer getPhotoBackCode() {
        return photoBackCode;
    }

    public void setPhotoBackCode(Integer photoBackCode) {
        this.photoBackCode = photoBackCode;
    }

    public Long getPicTime() {
        return picTime;
    }

    public void setPicTime(Long picTime) {
        this.picTime = picTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

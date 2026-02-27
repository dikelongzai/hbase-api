/**
 * Copyright © 2017 e6gps. All rights reserved.
 *
 * @version: V1.0
 */

package com.howard.atlas.basemodel;


import java.io.Serializable;

/**
 * 数据类型枚举
 * 采用2位数字字符标识数据类型
 * Created by wanggaoli@e6yun.com on 2017年4月6日 上午7:19:10. 
 */
public enum TerDataType implements Serializable {
    EAiTrack("01"),
    EAiStopTime("02"),
    EAiPicture("03"),
    EAiOil("05"),
    EAiTemp("04"),
    EAiICCard("06"),
    EAiTrailer("07"),
    EAiSTICCard("08"),
    EAiHumidity("09");

    private String index;


    private TerDataType(String index) {
        this.index = index;

    }

    public static TerDataType ValueOf(Integer index) {
        switch (index) {
            case 1:
                return EAiTrack;
            case 2:
                return EAiStopTime;
            case 3:
                return EAiPicture;
            case 4:
                return EAiTemp;
            case 5:
                return EAiOil;
            case 6:
                return EAiICCard;
            case 7:
                return EAiTrailer;
            case 8:
                return EAiSTICCard;
            case 9:
                return EAiHumidity;
            default:
                return null;
        }
    }

    /**
     * @return the index
     */
    public String getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(String index) {
        this.index = index;
    }


}

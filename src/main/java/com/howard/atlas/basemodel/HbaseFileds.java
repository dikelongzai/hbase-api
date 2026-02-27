package com.howard.atlas.basemodel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by houlongbin on 2017/6/8.
 */
public class HbaseFileds {
    /*湿度**/
    public static final String HBASE_COLUMN_HUMIDITY_H1 = TerDataType.EAiHumidity.getIndex() + "h1";
    public static final String HBASE_COLUMN_HUMIDITY_H2 = TerDataType.EAiHumidity.getIndex() + "h2";
    public static final String HBASE_COLUMN_HUMIDITY_H3 = TerDataType.EAiHumidity.getIndex() + "h3";
    public static final String HBASE_COLUMN_HUMIDITY_H4 = TerDataType.EAiHumidity.getIndex() + "h4";
    public static final String HBASE_COLUMN_HUMIDITY_H1_T = TerDataType.EAiHumidity.getIndex() + "h1T";
    public static final String HBASE_COLUMN_HUMIDITY_H2_T = TerDataType.EAiHumidity.getIndex() + "h2T";
    public static final String HBASE_COLUMN_HUMIDITY_H3_T = TerDataType.EAiHumidity.getIndex() + "h3T";
    public static final String HBASE_COLUMN_HUMIDITY_H4_T = TerDataType.EAiHumidity.getIndex() + "h4T";

    /*IC卡**/
    /**
     * IC卡编号
     */
    public static final String HBASE_COLUMN_ICCARD_ICNO = TerDataType.EAiICCard.getIndex() + "icno";
    /**
     * 0插卡,1拔卡,非接触式的给-1
     */
    public static final String HBASE_COLUMN_ICCARD_STATUSTYPE = TerDataType.EAiICCard.getIndex() + "stype";
    /**
     * 1非接触式的 2接触式的
     */
    public static final String HBASE_COLUMN_ICCARD_CARDTYPE = TerDataType.EAiICCard.getIndex() + "ctype";

    /*油量*/
    /**
     * 油箱个数
     */
    public static final String HBASE_COLUMN_AIOIL_OBN = TerDataType.EAiOil.getIndex() + "obn";
    /**
     * 油量1
     */
    public static final String HBASE_COLUMN_AIOIL_OC1 = TerDataType.EAiOil.getIndex() + "oc1";
    /**
     * 油量2
     */
    public static final String HBASE_COLUMN_AIOIL_OC2 = TerDataType.EAiOil.getIndex() + "oc2";

    /*EAiSTICCard **/
    /**
     * 打卡状态。1表示插卡，2表示拔卡
     */
    public static final String HBASE_COLUMN_STICCARD_STATUSTYPE = TerDataType.EAiSTICCard.getIndex() + "stype";
    /**
     * IC卡读取结果。0表示读卡成功，1~4表示读卡失败
     */
    public static final String HBASE_COLUMN_STICCARD_READRESULT = TerDataType.EAiSTICCard.getIndex() + "rs";
    /**
     * 司机姓名
     */
    public static final String HBASE_COLUMN_STICCARD_DRIVER_NAME = TerDataType.EAiSTICCard.getIndex() + "dn";
    /**
     * 从业资格证编码
     */
    public static final String HBASE_COLUMN_STICCARD_DQCN = TerDataType.EAiSTICCard.getIndex() + "dqcn";
    /**
     * 发证机构名称
     */
    public static final String HBASE_COLUMN_STICCARD_CIAN = TerDataType.EAiSTICCard.getIndex() + "cian";
    /**
     * 证件有效期
     */
    public static final String HBASE_COLUMN_STICCARD_ExpireTime = TerDataType.EAiSTICCard.getIndex() + "et";
    /**
     * 卡数字签名
     */
    public static final String HBASE_COLUMN_STICCARD_DigitalSign = TerDataType.EAiSTICCard.getIndex() + "ds";

    /*温度**/
    public static final String HBASE_COLUMN_TMP_T1 = TerDataType.EAiTemp.getIndex() + "t1";
    public static final String HBASE_COLUMN_TMP_T2 = TerDataType.EAiTemp.getIndex() + "t2";
    public static final String HBASE_COLUMN_TMP_T3 = TerDataType.EAiTemp.getIndex() + "t3";
    public static final String HBASE_COLUMN_TMP_T4 = TerDataType.EAiTemp.getIndex() + "t4";
    public static final String HBASE_COLUMN_TMP_T1_T = TerDataType.EAiTemp.getIndex() + "t1T";
    public static final String HBASE_COLUMN_TMP_T2_T = TerDataType.EAiTemp.getIndex() + "t2T";
    public static final String HBASE_COLUMN_TMP_T3_T = TerDataType.EAiTemp.getIndex() + "t3T";
    public static final String HBASE_COLUMN_TMP_T4_T = TerDataType.EAiTemp.getIndex() + "t4T";
    public static final String HBASE_COLUMN_TMP_ColdStatus = TerDataType.EAiTemp.getIndex() + "cs";

    /*甩挂**/
    /**
     * 标签ID
     */
    public static final String HBASE_COLUMN_TRAILER_RFID = TerDataType.EAiTrailer.getIndex() + "rfid";
    /**
     * 电压
     */
    public static final String HBASE_COLUMN_TRAILER__Voltage = TerDataType.EAiTrailer.getIndex() + "v";
    /**
     * 甩挂类型 1：无线 2：有线
     */
    public static final String HBASE_COLUMN_TRAILER__TrailerType = TerDataType.EAiTrailer.getIndex() + "tt";


    

    /*停车**/

    /**
     * 时长，秒
     */
    public static final String HBASE_COLUMN_STOP_StopSecs = TerDataType.EAiStopTime.getIndex() + "stopt";
    /**
     * 类型，48停车、49停车未熄火
     */
    public static final String HBASE_COLUMN_STOP_TheType = TerDataType.EAiStopTime.getIndex() + "type";
    /**
     * 停车开始标志,1为停车开始，2为停车结束
     */
    public static final String HBASE_COLUMN_STOP_StopBegin = TerDataType.EAiStopTime.getIndex() + "sb";
    /**
     * 停车流水号
     */
    public static final String HBASE_COLUMN_STOP_SSN = TerDataType.EAiStopTime.getIndex() + "ssn";

    /*轨迹**/
     public static final String INFO_FAMILY = "f";
     public static final String HBASE_COLUMN_TRACK_VEHICLEId = "vehicleId";
     public static final String HBASE_COLUMN_TRACK_GPS_TIME = "gpsT";
     public static final String HBASE_COLUMN_TRACK_CREATE_TIME = "createT";
     public static final String HBASE_COLUMN_TRACK_WID = "wid";
     public static final String HBASE_COLUMN_TRACK_TRANSTER = "transfer";
     public static final String HBASE_COLUMN_TRACK_LON = "lon";
     public static final String HBASE_COLUMN_TRACK_LAT = "lat";
     public static final String HBASE_COLUMN_TRACK_DERECT = "derect";
     public static final String HBASE_COLUMN_TRACK_SPEED = "speed";
     public static final String HBASE_COLUMN_TRACK_ODOMETER = "odometer";
     public static final String HBASE_COLUMN_TRACK_ACC_STATUS = "accS";
     public static final String HBASE_COLUMN_TRACK_LINE_STATUS = "lineS";
     public static final String HBASE_COLUMN_TRACK_LO_STATUS = "loS";
     public static final String HBASE_COLUMN_TRACK_STATUS = "status";
     /*在线实时写入多出来的字段**/
     public static final String HBASE_COLUMN_TRACK_HEIGHT="height";
    /**
     * 数据终端ID
     */
    public static final String HBASE_COLUMN_TRACK_DataTerminalID="tid";
    /**
     * 基站信息
     */
    public static final String HBASE_COLUMN_TRACK_Station="station";
    /**
     * 数据源 0 GPS定位 1 基站定位  默认是0
     */
    public static final String HBASE_COLUMN_TRACK_DataSourceID="dsid";

    public static  final Map<String,String> HBASECOL_JSONCOL=new HashMap<String,String>();
    static {
        HBASECOL_JSONCOL.put(HBASE_COLUMN_TRACK_VEHICLEId,"VehicleID");
        HBASECOL_JSONCOL.put(HBASE_COLUMN_TRACK_GPS_TIME,"GpsTime");
        HBASECOL_JSONCOL.put(HBASE_COLUMN_TRACK_WID,"Wid");
    }




}

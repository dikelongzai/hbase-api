/**
 * Copyright © 2017 e6gps. All rights reserved.
 *
 * @version: V1.0
 */
package com.howard.atlas.basemodel;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.Serializable;

/**
 * 总线汇总模型 Created by wanggaoli@e6yun.com on 2017年4月5日 下午7:27:36.
 */
public class RProcessModel implements Serializable {
    public static final long MAX_GPS_TIME = 99999999999999L;
    @JSONField(ordinal = 0)
    private AiTrack aiTrack;
    @JSONField(ordinal = 1)
    private AiStopTime aiStopTime;
    @JSONField(ordinal = 2)
    private AiPicture aiPicture;
    @JSONField(ordinal = 3)
    private AiOil aiOil;
    @JSONField(ordinal = 4)
    private AiTemp aiTemp;
    @JSONField(ordinal = 5)
    private AiICCard aiICCard;
    @JSONField(ordinal = 6)
    private AiTrailer aiTrailer;
    @JSONField(ordinal = 7)
    private AiSTICCard aiSTICCard;
    @JSONField(ordinal = 8)
    private AiHumidity aiHumidity;

    @JSONField(ordinal = 9)
    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    private String rowKey;

    public RProcessModel(Result result, boolean isSample) {
        if (isSample) {
            //轨迹
            if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_VEHICLEId)) || result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DataTerminalID))) {
                AiTrack aitrack = new AiTrack();

                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_VEHICLEId))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_VEHICLEId)) != null) {
                        aitrack.setVehicleID(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_VEHICLEId))));
                    }
                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_GPS_TIME))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_GPS_TIME)) != null) {
                        aitrack.setGpsTime(Bytes.toLong(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_GPS_TIME))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_CREATE_TIME))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_CREATE_TIME)) != null) {
                        aitrack.setUpdateLong(Bytes.toLong(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_CREATE_TIME))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_WID))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_WID)) != null) {
                        aitrack.setWid(Bytes.toString(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_WID))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LON))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LON)) != null) {
                        aitrack.setLon(Bytes.toBigDecimal(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LON))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LAT))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LAT)) != null) {
                        aitrack.setLat(Bytes.toBigDecimal(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LAT))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DERECT))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DERECT)) != null) {
                        aitrack.setDirection(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DERECT))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_SPEED))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_SPEED)) != null) {
                        aitrack.setSpeed(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_SPEED))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_ODOMETER))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_ODOMETER)) != null) {
                        aitrack.setOdometer(Bytes.toBigDecimal(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_ODOMETER))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_ACC_STATUS))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_ACC_STATUS)) != null) {
                        aitrack.setACCStatus(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_ACC_STATUS))));
                    }

                }
                try {
                    if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LINE_STATUS))) {
                        if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LINE_STATUS)) != null) {
                            aitrack.setLineStatus(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LINE_STATUS))));
                        }

                    }


                    if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LO_STATUS))) {
                        if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LO_STATUS)) != null) {
                            aitrack.setLoStatus(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LO_STATUS))));
                        }

                    }

                    if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_STATUS))) {
                        if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_STATUS)) != null) {
                            aitrack.setStatus(Bytes.toString(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_STATUS))));
                        }

                    }
            /* 总线多出来四个字段**/
                    if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_HEIGHT))) {
                        if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_HEIGHT)) != null) {
                            aitrack.setHeight(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_HEIGHT))));
                        }

                    }
                    if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DataTerminalID))) {
                        if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DataTerminalID)) != null) {
                            aitrack.setDataTerminalID(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DataTerminalID))));
                        }

                    }
                    if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_Station))) {
                        if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_Station)) != null) {
                            aitrack.setStation(Bytes.toString(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_Station))));
                        }

                    }
                    if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DataSourceID))) {
                        if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DataSourceID)) != null) {
                            aitrack.setDataSourceID(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DataSourceID))));
                        }

                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }

                setAiTrack(aitrack);
            }
            String rowKey = Bytes.toString(result.getRow());
            setRowKey(rowKey);
        }

    }

    public RProcessModel(Result result) {

        //轨迹
        if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_VEHICLEId)) || result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DataTerminalID))) {
            AiTrack aitrack = new AiTrack();

            if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_VEHICLEId))) {
                if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_VEHICLEId)) != null) {
                    aitrack.setVehicleID(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_VEHICLEId))));
                }
            }
            if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_GPS_TIME))) {
                if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_GPS_TIME)) != null) {
                    aitrack.setGpsTime(Bytes.toLong(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_GPS_TIME))));
                }

            }
            if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_CREATE_TIME))) {
                if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_CREATE_TIME)) != null) {
                    aitrack.setUpdateLong(Bytes.toLong(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_CREATE_TIME))));
                }

            }
            if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_WID))) {
                if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_WID)) != null) {
                    aitrack.setWid(Bytes.toString(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_WID))));
                }

            }
            if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LON))) {
                if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LON)) != null) {
                    aitrack.setLon(Bytes.toBigDecimal(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LON))));
                }

            }
            if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LAT))) {
                if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LAT)) != null) {
                    aitrack.setLat(Bytes.toBigDecimal(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LAT))));
                }

            }
            if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DERECT))) {
                if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DERECT)) != null) {
                    aitrack.setDirection(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DERECT))));
                }

            }
            if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_SPEED))) {
                if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_SPEED)) != null) {
                    aitrack.setSpeed(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_SPEED))));
                }

            }
            if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_ODOMETER))) {
                if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_ODOMETER)) != null) {
                    aitrack.setOdometer(Bytes.toBigDecimal(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_ODOMETER))));
                }

            }
            if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_ACC_STATUS))) {
                if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_ACC_STATUS)) != null) {
                    aitrack.setACCStatus(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_ACC_STATUS))));
                }

            }
            try {
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LINE_STATUS))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LINE_STATUS)) != null) {
                        aitrack.setLineStatus(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LINE_STATUS))));
                    }

                }


                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LO_STATUS))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LO_STATUS)) != null) {
                        aitrack.setLoStatus(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_LO_STATUS))));
                    }

                }

                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_STATUS))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_STATUS)) != null) {
                        aitrack.setStatus(Bytes.toString(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_STATUS))));
                    }

                }
            /* 总线多出来四个字段**/
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_HEIGHT))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_HEIGHT)) != null) {
                        aitrack.setHeight(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_HEIGHT))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DataTerminalID))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DataTerminalID)) != null) {
                        aitrack.setDataTerminalID(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DataTerminalID))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_Station))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_Station)) != null) {
                        aitrack.setStation(Bytes.toString(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_Station))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DataSourceID))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DataSourceID)) != null) {
                        aitrack.setDataSourceID(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRACK_DataSourceID))));
                    }

                }
            } catch (IllegalArgumentException e) {

                e.printStackTrace();
            }

            setAiTrack(aitrack);
        }
        //分别组装
        if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H1))) {
            AiHumidity aiHumidity = new AiHumidity();
            aiHumidity.setH1(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H1))));
            try {
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H2))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H2)) != null) {
                        aiHumidity.setH2(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H2))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H3))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H3)) != null) {
                        aiHumidity.setH3(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H3))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H4))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H4)) != null) {
                        aiHumidity.setH4(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H4))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H2_T))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H2_T)) != null) {
                        aiHumidity.setH2Time(Bytes.toLong(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H2_T))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H3_T))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H3_T)) != null) {
                        aiHumidity.setH3Time(Bytes.toLong(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H3_T))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H4_T))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H4_T)) != null) {
                        aiHumidity.setH4Time(Bytes.toLong(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H4_T))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H1_T))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H1_T)) != null) {
                        aiHumidity.setH1Time(Bytes.toLong(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_HUMIDITY_H1_T))));
                    }

                }
            } catch (Exception e) {

                e.printStackTrace();
            }
            setAiHumidity(aiHumidity);
        }

        //IC卡
        if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_ICCARD_ICNO))) {
            AiICCard aiICCard = new AiICCard();
            aiICCard.setICNO(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_ICCARD_ICNO))));
            try {
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_ICCARD_CARDTYPE))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_ICCARD_CARDTYPE)) != null) {
                        aiICCard.setCardType(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_ICCARD_CARDTYPE))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_ICCARD_STATUSTYPE))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_ICCARD_STATUSTYPE)) != null) {
                        aiICCard.setStatusType(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_ICCARD_STATUSTYPE))));
                    }

                }
            } catch (Exception e) {

                e.printStackTrace();
            }
            setAiICCard(aiICCard);
        }
        //油量
        if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_AIOIL_OC1))) {
            AiOil aiOil = new AiOil();
            aiOil.setOilCalc(Bytes.toBigDecimal(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_AIOIL_OC1))));
            try {
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_AIOIL_OBN))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_AIOIL_OBN)) != null) {
                        aiOil.setOilBoxNumber(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_AIOIL_OBN))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_AIOIL_OC2))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_AIOIL_OC2)) != null) {
                        aiOil.setOilCalc2(Bytes.toBigDecimal(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_AIOIL_OC2))));
                    }

                }
            } catch (Exception e) {

                e.printStackTrace();
            }
            setAiOil(aiOil);
        }
        //部标标准IC卡
        if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_CIAN))) {
            AiSTICCard aiSTICCard = new AiSTICCard();
            aiSTICCard.setCIAN(Bytes.toString(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_CIAN))));
            try {
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_STATUSTYPE))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_STATUSTYPE)) != null) {
                        aiSTICCard.setStatusType(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_STATUSTYPE))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_DigitalSign))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_DigitalSign)) != null) {
                        aiSTICCard.setDigitalSign(Bytes.toString(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_DigitalSign))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_DQCN))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_DQCN)) != null) {
                        aiSTICCard.setDQCN(Bytes.toString(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_DQCN))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_DRIVER_NAME))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_DRIVER_NAME)) != null) {
                        aiSTICCard.setDriverName(Bytes.toString(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_DRIVER_NAME))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_ExpireTime))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_ExpireTime)) != null) {
                        aiSTICCard.setExpireTime(Bytes.toLong(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_ExpireTime))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_READRESULT))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_READRESULT)) != null) {
                        aiSTICCard.setReadResult(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STICCARD_READRESULT))));
                    }

                }
            } catch (Exception e) {

                e.printStackTrace();
            }
            setAiSTICCard(aiSTICCard);
        }
        //停车
        if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STOP_SSN))) {
            AiStopTime aiStopTime = new AiStopTime();
            aiStopTime.setSSN(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STOP_SSN))));
            try {
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STOP_StopBegin))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STOP_StopBegin)) != null) {
                        aiStopTime.setStopBegin(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STOP_StopBegin))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STOP_StopSecs))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STOP_StopSecs)) != null) {
                        aiStopTime.setStopSecs(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STOP_StopSecs))));
                    }

                }
                if (getAiStopTime().getTheType() != null) {
                    if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STOP_StopBegin))) {
                        if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STOP_StopBegin)) != null) {
                            aiStopTime.setTheType(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_STOP_StopBegin))));
                        }
                    }


                }
            } catch (Exception e) {

                e.printStackTrace();
            }
            setAiStopTime(aiStopTime);
        }

        //温度
        if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T1))) {
            AiTemp aiTemp = new AiTemp();
            aiTemp.setT1(Bytes.toBigDecimal(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T1))));
            try {
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T2))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T2)) != null) {
                        aiTemp.setT2(Bytes.toBigDecimal(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T2))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T3))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T3)) != null) {
                        aiTemp.setT3(Bytes.toBigDecimal(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T3))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T4))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T4)) != null) {
                        aiTemp.setT4(Bytes.toBigDecimal(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T4))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T1_T))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T1_T)) != null) {
                        aiTemp.setT1Time(Bytes.toLong(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T1_T))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T2_T))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T2_T)) != null) {
                        aiTemp.setT2Time(Bytes.toLong(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T2_T))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T3_T))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T3_T)) != null) {
                        aiTemp.setT3Time(Bytes.toLong(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T3_T))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T4_T))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T4_T)) != null) {
                        aiTemp.setT4Time(Bytes.toLong(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_T4_T))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_ColdStatus))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_ColdStatus)) != null) {
                        aiTemp.setColdStatus(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TMP_ColdStatus))));
                    }

                }
            } catch (Exception e) {

                e.printStackTrace();
            }
            setAiTemp(aiTemp);
        }
        //甩挂
        if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRAILER_RFID))) {
            AiTrailer aiTrailer = new AiTrailer();
            aiTrailer.setRFID(Bytes.toString(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRAILER_RFID))));
            try {
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRAILER__TrailerType))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRAILER__TrailerType)) != null) {
                        aiTrailer.setTrailerType(Bytes.toInt(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRAILER__TrailerType))));
                    }

                }
                if (result.containsColumn(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRAILER__Voltage))) {
                    if (result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRAILER__Voltage)) != null) {
                        aiTrailer.setVoltage(Bytes.toBigDecimal(result.getValue(Bytes.toBytes(HbaseFileds.INFO_FAMILY), Bytes.toBytes(HbaseFileds.HBASE_COLUMN_TRAILER__Voltage))));
                    }

                }
            } catch (Exception e) {

                e.printStackTrace();
            }
            setAiTrailer(aiTrailer);
        }


        String rowKey = Bytes.toString(result.getRow());
        setRowKey(rowKey);
    }

    public RProcessModel(JSONObject processModel) {
        if (processModel == null) {
            return;
        }
        if (processModel.getJSONObject("AiTrack") != null) {
            setAiTrack(new AiTrack(processModel.getJSONObject("AiTrack")));
        }
        if (processModel.getJSONObject("AiStopTime") != null) {
            setAiStopTime(new AiStopTime(processModel.getJSONObject("AiStopTime")));
        }
        if (processModel.getJSONObject("AiOil") != null) {
            setAiOil(new AiOil(processModel.getJSONObject("AiOil")));
        }
        if (processModel.getJSONObject("AiTemp") != null) {
            setAiTemp(new AiTemp(processModel.getJSONObject("AiTemp")));
        }
        if (processModel.getJSONObject("AiICCard") != null) {
            setAiICCard(new AiICCard(processModel.getJSONObject("AiICCard")));
        }
        if (processModel.getJSONObject("AiTrailer") != null) {
            setAiTrailer(new AiTrailer(processModel.getJSONObject("AiTrailer")));
        }
        if (processModel.getJSONObject("AiSTICCard") != null) {
            setAiSTICCard(new AiSTICCard(processModel.getJSONObject("AiSTICCard")));
        }
        if (processModel.getJSONObject("AiHumidity") != null) {
            setAiHumidity(new AiHumidity(processModel.getJSONObject("AiHumidity")));
        }
        if (processModel.getJSONObject("AiPicture") != null) {
            setAiPicture(new AiPicture(processModel.getJSONObject("AiPicture")));
        }
    }

    /**
     * @return the aiTrack
     */
    public AiTrack getAiTrack() {
        return aiTrack;
    }

    /**
     * @param aiTrack the aiTrack to set
     */
    public void setAiTrack(AiTrack aiTrack) {
        this.aiTrack = aiTrack;
    }

    /**
     * @return the aiStopTime
     */
    public AiStopTime getAiStopTime() {
        return aiStopTime;
    }

    /**
     * @param aiStopTime the aiStopTime to set
     */
    public void setAiStopTime(AiStopTime aiStopTime) {
        this.aiStopTime = aiStopTime;
    }

    /**
     * @return the aiOil
     */
    public AiOil getAiOil() {
        return aiOil;
    }

    /**
     * @param aiOil the aiOil to set
     */
    public void setAiOil(AiOil aiOil) {
        this.aiOil = aiOil;
    }

    /**
     * @return the aiTemp
     */
    public AiTemp getAiTemp() {
        return aiTemp;
    }

    /**
     * @param aiTemp the aiTemp to set
     */
    public void setAiTemp(AiTemp aiTemp) {
        this.aiTemp = aiTemp;
    }

    /**
     * @return the aiICCard
     */
    public AiICCard getAiICCard() {
        return aiICCard;
    }

    /**
     * @param aiICCard the aiICCard to set
     */
    public void setAiICCard(AiICCard aiICCard) {
        this.aiICCard = aiICCard;
    }

    /**
     * @return the aiTrailer
     */
    public AiTrailer getAiTrailer() {
        return aiTrailer;
    }

    /**
     * @param aiTrailer the aiTrailer to set
     */
    public void setAiTrailer(AiTrailer aiTrailer) {
        this.aiTrailer = aiTrailer;
    }

    /**
     * @return the aiSTICCard
     */
    public AiSTICCard getAiSTICCard() {
        return aiSTICCard;
    }

    /**
     * @param aiSTICCard the aiSTICCard to set
     */
    public void setAiSTICCard(AiSTICCard aiSTICCard) {
        this.aiSTICCard = aiSTICCard;
    }

    /**
     * @return the aiHumidity
     */
    public AiHumidity getAiHumidity() {
        return aiHumidity;
    }

    /**
     * @param aiHumidity the aiHumidity to set
     */
    public void setAiHumidity(AiHumidity aiHumidity) {
        this.aiHumidity = aiHumidity;
    }

    public AiPicture getAiPicture() {
        return aiPicture;
    }

    public void setAiPicture(AiPicture aiPicture) {
        this.aiPicture = aiPicture;
    }
}

package com.howard.hbase.util;

import org.apache.hadoop.hbase.util.Bytes;

/**
 * Created by zhenjie.wang on 2015/8/19.
 */
public class ConstantProperties {
    public static String COMMON_PROP = "common.properties";
    // rowkey分隔符
    public static final String ROWKEY_DELIMITER = "-";
    // 导入数据文件中每一行数据 列之间的分隔符
    public static final String FIELD_DELIMITER = "\t";
    // 数据导入表
    public static final byte[] TABLE_AITRACKP = Bytes.toBytes("aitrackp");
    // 数据导入表
    public static final String TABLE_GPS_DATA = "aitrackp";
    // 表的列族
    public static final byte[] FAMILY_BYTE = Bytes.toBytes("f");
    // HBase轨迹表aitrackp的列.对应hive表的字段{gpstime,createdTime,wid,transfer,lon,lat,direction,speed,odometer,accStatus,lineStatus,loStatus,status}
    public static final String[] TABLE_COLUMS = { "g","c", "w", "t", "lo", "la",
            "d", "sp", "o", "as", "is", "os", "s" };
    // HBase Cell的操作类型 Put 4
    public static final byte OPERATION_TYPE = 4;
    public static  final String HBASE_STARTROW_POS=ROWKEY_DELIMITER+"#";
    public static  final String HBASE_END_POS=ROWKEY_DELIMITER+":";
}

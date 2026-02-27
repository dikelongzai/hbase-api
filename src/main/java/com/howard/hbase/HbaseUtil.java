package com.howard.hbase;

import com.alibaba.fastjson.JSON;
import com.howard.atlas.basemodel.RProcessModel;
import com.howard.hbase.util.ConstantProperties;
import com.howard.hbase.util.DateFormatEnum;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by houlongbin on 2017/5/9.
 */
public class HbaseUtil {
    private static final Logger logger = LoggerFactory.getLogger(HbaseUtil.class);

    static HBaseService service = new HBaseServiceImpl();
    public static int pageSize=10000;

    /**
     * @param carId
     * @param startTime
     * @param endTime
     * @return
     */
   public   static List<RProcessModel> getGpsData(String carId, String startTime, String endTime, DateFormatEnum dateFormatEnum) throws Exception {
        List<RProcessModel> list = new LinkedList<RProcessModel>();
        Scan s = new Scan();
        //这里有一个merge的操作所以start和end要注意下
        s.setStartRow(Bytes.toBytes(getStartRowOrEndRow(carId, endTime, dateFormatEnum)));
        s.setStopRow(Bytes.toBytes(getStartRowOrEndRow(carId, startTime, dateFormatEnum)));
        ResultScanner scandata = service.ScanData(ConstantProperties.TABLE_GPS_DATA, s);
        for (Result r : scandata) {
            list.add(new RProcessModel(r));
        }
        return list;
   }
    public   static List<RProcessModel> getGpsDataMills(String carId, long startTime, long endTime) throws Exception {
        List<RProcessModel> list = new LinkedList<RProcessModel>();
        Scan s = new Scan();
        //这里有一个merge的操作所以start和end要注意下
        s.setStartRow(Bytes.toBytes(composeKey(carId, endTime)));
        s.setStopRow(Bytes.toBytes(composeKey(carId, startTime)));
        ResultScanner scandata = service.ScanData(ConstantProperties.TABLE_GPS_DATA, s);
        for (Result r : scandata) {
            list.add(new RProcessModel(r));
        }
        return list;
    }
    public static List<RProcessModel> getGpsDataByCarId(String carId){
        List<RProcessModel> list = new LinkedList<RProcessModel>();
        Scan s = new Scan();
        //这里有一个merge的操作所以start和end要注意下
        s.setStartRow(Bytes.toBytes(carId+ConstantProperties.HBASE_STARTROW_POS));
        s.setStopRow(Bytes.toBytes(carId+ConstantProperties.HBASE_END_POS));
//        s.setMaxResultSize(20);
        ResultScanner scandata = service.ScanData(ConstantProperties.TABLE_GPS_DATA, s);
        for (Result r : scandata) {
            list.add(new RProcessModel(r));
        }
        return list;
    }
    public static List<RProcessModel> getPageGpsDataByCarId(String carId,String lastRow,int pageSize){

        int totalNums = 0;
        List<RProcessModel> list = new LinkedList<RProcessModel>();
        Scan s = new Scan();
        byte[] POSTFIX = new byte[1];
        List flList = new ArrayList();
        //这里有一个merge的操作所以start和end要注意下
        if (StringUtils.isNotEmpty(lastRow))
            s.setStartRow(Bytes.add(lastRow.getBytes(),POSTFIX));
        else {
            s.setStartRow(Bytes.toBytes(carId+ConstantProperties.HBASE_STARTROW_POS));
        }
        s.setStopRow(Bytes.toBytes(carId+ConstantProperties.HBASE_END_POS));
        Filter filter = new PageFilter(pageSize);
        flList.add(filter);
        s.setFilter(new FilterList(FilterList.Operator.MUST_PASS_ALL, flList));
        s.setCaching(1000);
        s.setCacheBlocks(false);
        ResultScanner scandata = service.ScanData(ConstantProperties.TABLE_GPS_DATA, s);
        for (Result r : scandata) {
            totalNums += 1;
            if (totalNums<=pageSize) {
                list.add(new RProcessModel(r));
            }

        }
        return list;
    }
    public   static List<RProcessModel> getPageGpsDataMills(String carId, long startTime, long endTime,String lastRow,int pageSize ) throws Exception {
        long start=System.currentTimeMillis();
        int totalNums = 0;
        byte[] POSTFIX = new byte[1];
        List flList = new ArrayList();
        List<RProcessModel> list = new LinkedList<RProcessModel>();
        Scan s = new Scan();
        //这里有一个merge的操作所以start和end要注意下
        if (StringUtils.isNotEmpty(lastRow))
            s.setStartRow(Bytes.add(lastRow.getBytes(),POSTFIX));
        else {
            s.setStartRow(Bytes.toBytes(composeKey(carId, endTime)));
        }
        //这里有一个merge的操作所以start和end要注意下
//        s.setStartRow(Bytes.toBytes(composeKey(carId, endTime)));
        s.setStopRow(Bytes.toBytes(composeKey(carId, startTime)));
        Filter filter = new PageFilter(pageSize);
        flList.add(filter);
        s.setFilter(new FilterList(FilterList.Operator.MUST_PASS_ALL, flList));
        s.setCaching(1000);
        s.setCacheBlocks(false);
        ResultScanner scandata = service.ScanData(ConstantProperties.TABLE_GPS_DATA, s);
        for (Result r : scandata) {
            totalNums += 1;
            if (totalNums<=pageSize) {
                list.add(new RProcessModel(r));
            }
        }
        logger.info("getPageGpsDataMills cost="+(System.currentTimeMillis()-start)+"ms;result="+ JSON.toJSONString(list)+";startTime="+startTime+";carId="+carId+";endTime="+endTime+";lastRow="+lastRow+";");
        return list;
    }
    private static String getStartRowOrEndRow(String carId, String time, DateFormatEnum dateFormatEnum) throws Exception {
        long gpsTime = new SimpleDateFormat(dateFormatEnum.toString()).parse(time).getTime();
        return composeKey(carId, gpsTime);
    }

    public static String composeKey(String vehicleId, long gpsTime) {
        String rowKey = "";
        long time = RProcessModel.MAX_GPS_TIME - gpsTime;
        rowKey = vehicleId + ConstantProperties.ROWKEY_DELIMITER + time;
        return rowKey;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getStartRowOrEndRow("1234", "2014-12-23", DateFormatEnum.YYYY_MM_DD));
    }

}

package com.howard.hbase.test;

import com.alibaba.fastjson.JSON;
import com.howard.atlas.basemodel.RProcessModel;
import com.howard.hbase.HbaseUtil;
import com.howard.hbase.util.*;
import com.howard.leetcode.BinaryTreeNode;
import com.howard.leetcode.LeetCode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houlongbin on 2017/5/8.
 */
public class HbaseTest {
    @Test
    public void testPut() throws Exception {
//        String line = "11764	2013-09-19 00:15:55.000	2013-09-25 14:51:50.653	13256006670	01	113.748720	22.964982	1	0	7483.500	0001	01	03	 ";
//        String[] items = line.split("\t", -1);
//        long time=1496826654000L;
//        String vehicleId = (items[0]);
//        double lon = 0;
//        double lat = 0;
//        long gt = PlatformUtil.date2Timestamp(items[1]);
//        byte[] rowKeyBytes = Bytes.toBytes(time);
//        Put put = new Put(rowKeyBytes);
//        Cell cell = CellUtil.createCell(rowKeyBytes, ConstantProperties.FAMILY_BYTE, Bytes.toBytes("col1"), System.currentTimeMillis(), ConstantProperties.OPERATION_TYPE, Bytes.toBytes("col1"));
//        put.add(cell);
//        HBaseUtil.put("test",put);
        // 生成Put对象
//        if(items.length>2) {
//            Put put = new Put(rowKeyBytes);
//            long timestamp = 0;
//            try {
//                timestamp = PlatformUtil.date2Timestamp(items[2]);
//            } catch (Exception e) {
//                timestamp = System.currentTimeMillis();
//            }
//            for (int i = 1; i < items.length; i++) {
//                if (StringUtils.isNotBlank(items[i])) {
//                    byte[] qualifier = Bytes.toBytes(ConstantProperties.TABLE_COLUMS[i - 1]);
//                    byte[] val = {};
//                    switch (i) {
//                        case 1:
//                            //时间长度23位,减少15个字节
//                            val = Bytes.toBytes(gt);
//                            break;
//                        case 2:
//                            //时间长度23位,减少15个字节
//                            val = Bytes.toBytes(timestamp);
//                            break;
//                        case 5:
//                            lon = Double.valueOf(items[5]);
//                            val = Bytes.toBytes(lon);
//                            break;
//                        case 6:
//                            lat = Double.valueOf(items[6]);
//                            //经度为10位,减少2个字节
//                            val = Bytes.toBytes(lat);
//                            break;
//                        default:
//                            val = Bytes.toBytes(items[i]);
//                    }
//                    Cell cell = CellUtil.createCell(rowKeyBytes, ConstantProperties.FAMILY_BYTE, qualifier, timestamp, ConstantProperties.OPERATION_TYPE, val);
//                    put.add(cell);
//                }
//            }
//            if (Math.abs(lat) > 90.0 || Math.abs(lon) > 180.0) {
//                return;
//            }
//            HBaseUtil.put("aitrackp1000",put);
//        }
    }

    @Test
    public void testGet() throws Exception {
        List<RProcessModel> list1 = HbaseUtil.getGpsData("1004322", "2017-06-01", "2017-06-20", DateFormatEnum.YYYY_MM_DD);
        System.out.println(JSON.toJSONString(list1));
        List<RProcessModel> list = HbaseUtil.getGpsData("1004322", "2017-06-01", "2017-06-20", DateFormatEnum.YYYY_MM_DD);
        list = HbaseUtil.getPageGpsDataByCarId("1004322", "", 10);
        System.out.println(JSON.toJSON(list));
        String lastRow = "";
        int i = 0;
//        while (true){
//            list=E6HbaseUtil.getPageGpsDataByCarId("1004322",lastRow,10);
//            System.out.println(JSON.toJSON(list));
//            i++;
//            if(list.size()<10){
//                break;
//            }else {
//                lastRow=list.get(list.size()-1).getRowKey();
//                System.out.println("迭代次数"+i+";查询条数"+list.size()+";lastRow="+lastRow);
//            }
//
//
//
//        }
        lastRow = "";
        list = HbaseUtil.getPageGpsDataMills("1004725", 1498629069628L, 1498715468898L, lastRow, 100);
        System.out.println(JSON.toJSON(list));
//        while (true){
//            list=E6HbaseUtil.getPageGpsDataMills("1004322",1496851200000L,1496937600000L,lastRow,100);
//            System.out.println(JSON.toJSON(list));
//            i++;
//            if(list.size()<100){
//                break;
//            }else {
//                lastRow=list.get(list.size()-1).getRowKey();
//                System.out.println("mills迭代次数"+i+";查询条数"+list.size()+";lastRow="+lastRow);
//            }
//        }

//        System.out.println(list.size()+"size");
//        for(RProcessModel ai:list){
//            System.out.println(JSON.toJSON(ai));
//        }
//        list=E6HbaseUtil.getPageGpsDataByCarId("1004322","1004322-98503002569999");
//        System.out.println(list.size()+"size");
//        for(RProcessModel ai:list){
//            System.out.println(JSON.toJSON(ai));
//        }
//        list=E6HbaseUtil.getGpsDataMills("1004322",1496246400000L,1497888000000L);
//        for(RProcessModel ai:list){
//            System.out.println(JSON.toJSON(ai));
//        }
    }


}

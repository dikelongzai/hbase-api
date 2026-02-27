package com.howard.hbase;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;

import java.util.List;

/**
 * HBase 服务抽象类
 * Created by babylon on 2016/12/6.
 */

public abstract class AbstractHBaseService implements HBaseService {

    public void put(String tableName, Put put, boolean waiting) {}

    public void batchPut(final String tableName, final List<Put> puts, boolean waiting) {}

    public <T> Result[] getRows(String tablename, List<T> rows) {return null;}

    public Result getRow(String tablename, byte[] row) {return null;}


}

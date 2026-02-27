package com.howard.hbase.util;

/**
 * Created by houlongbin on 2017/5/9.
 */
public enum DateFormatEnum {
    YYYYMMDD("yyyyMMdd"),
    YYYY_MM_DD("yyyy-MM-dd"),
    YYYY_MM_DD_BLANK_HH_MM_SS("yyyy-MM-dd HH:mm:ss"),YYYY_MM_DD_BLANK_HH_MM_SS_sss("yyyy-MM-dd HH:mm:ss.SSS");
    /**
     * 待生成的字符串
     */
    private String dateFormat;
    private DateFormatEnum(final String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public String toString() {
        return this.dateFormat;
    }
}

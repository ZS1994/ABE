package com.abe.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
/**
 * 将的Timestamp、Date转换为json中的日期字符串
 * @author 张顺
 * 2016-10-26 15:25:04
 */
public class JsonDateValueProcessor implements JsonValueProcessor {
    public static final String Default_DATE_PATTERN ="yyyy-MM-dd HH:mm:ss";
    private DateFormat dateFormat ;
    public JsonDateValueProcessor(String datePattern){
        try{
            dateFormat  = new SimpleDateFormat(datePattern);}
        catch(Exception e ){
            dateFormat = new SimpleDateFormat(Default_DATE_PATTERN);
        }
    }
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return process(value);
    }
    public Object processObjectValue(String key, Object value,JsonConfig jsonConfig) {
        return process(value);
    }
    private Object process(Object value){
        return value==null?"":dateFormat.format((Date)value);
    }
}
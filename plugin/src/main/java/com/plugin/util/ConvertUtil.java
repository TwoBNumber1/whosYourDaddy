package com.plugin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 转换工具类
 * @author LAO
 *
 */
@Component
public class ConvertUtil {

	/**
	 * 将coolq上报消息中的时间戳转换成时间
	 * @param timeStampString
	 * @return 格式化后的时间字符串
	 */
	public  String timeStampToTime(String timeStampString) {
		
		long timeStampLong =  (Long.parseLong(timeStampString))*1000L ;
		SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return simpleDateFormat.format(new Date(timeStampLong));
	}
	
}

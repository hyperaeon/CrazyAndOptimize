package com.netease.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateFormatUtil {

    /**
     * @Function 给密码设置指定的过期时长
     * @param duetime
     * @author ZhangLei
     * @serialData 2016-5-17 10:24:59
     * @return 一个需要的格式的日期
     */
    public static Timestamp getUpMothDate(int duetime) {

	Date date = null;// 获得系统时间.
	Calendar lastDate = Calendar.getInstance();
	lastDate.add(Calendar.MONTH, duetime);
	// 将时间格式转换成符合Timestamp要求的String格式.
	String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
		.format(lastDate.getTime());

	// 把String字符串格式的时间转换成Timestamp格式；
	Timestamp overdate = Timestamp.valueOf(nowTime);
	return overdate;
    }
}

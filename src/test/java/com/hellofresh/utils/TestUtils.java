package com.hellofresh.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils {
	
	public static String getDateString(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return dateFormat.format(date);
	}

}

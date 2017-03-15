package com.chaos.stanfield.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateFormatConvertor {

	public Calendar stringToCalendar(String dateStr) throws ParseException{
		try{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=sdf.parse(dateStr);
		Calendar calendar=sdf.getCalendar();
		return calendar;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Calendar getTodaysDate(){
		Date date=new Date();
		Calendar myCal = new GregorianCalendar();
		myCal.setTime(date);
		return myCal;
	}
	
	
}

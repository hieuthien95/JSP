package com.vaannila;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			final SimpleDateFormat ddMMyy = new SimpleDateFormat("yyyy/MM/dd");
			
			String ymd = "2017/02/05";
			Date date = ddMMyy.parse(ymd);
			
			
			Calendar mycal = new GregorianCalendar(date.getYear(), date.getMonth() + 1, date.getDay());
			int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28

			System.out.println(date.toString().substring(0, 3) + " - " + ymd);
			System.out.println(daysInMonth);
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String sql ="SELECT * "
				+ "FROM employee_mst e, worktime w, wrktime_ot ot "
				+ "WHERE e.EMP_CODE = w.EMP_CODE "
				+ "AND w.CAL_YMD >= 20170601 "
				+ "AND w.CAL_YMD <= 20170631";
		

		
	}

}

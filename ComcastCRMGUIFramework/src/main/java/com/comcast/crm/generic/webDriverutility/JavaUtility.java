package com.comcast.crm.generic.webDriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random=new Random();
		int rno=random.nextInt(5000);
		return rno;		
	}
	public String getSystemDateYYYYDDMM() {
		Date dt=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String Actualdate=sdf.format(dt);
	    return Actualdate;
	}
	public String getRequiredDateYYYYDDMM(int days) {
		Date dt=new Date();		
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");	
	String current=sim.format(dt);	
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqdate=sim.format(cal.getTime());
		return reqdate;
	}
}

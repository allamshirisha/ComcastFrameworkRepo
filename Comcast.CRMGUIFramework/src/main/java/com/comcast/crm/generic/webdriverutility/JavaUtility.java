package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int  getRandomNumber() {
		Random random = new Random();
	int randomint =	random.nextInt(100000);
	return randomint;
	}
	public String gettSystemDateYYYYMMDD() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String data = sdf.format(date);
		return data;
	}
	public String getRequiredDateYYYYDDMM(int days) {
		
			
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	
	//Calendar  cal = sim.getCalendar();
	 Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,days);
	String requireddate =	sim.format(cal.getTime());
		return requireddate;
		
	}
}

package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;

public class JavaUtility {

	public int getrandomNumber() {
	Random random=new Random();
	int rendomInt=	random.nextInt(50000);
		return rendomInt;
	}
	public String getSystemDataYYYYMMDD(WebDriver driver) {
		Date dateObj=new Date();
		
		SimpleDateFormat sf=new SimpleDateFormat("DD-MM-YYYY");
		String date=sf.format(dateObj);
		return date;
	}
	public String getRequiredDateYYYYMMDD(int days) {
		Date dateObj=new Date();
		SimpleDateFormat smp= new SimpleDateFormat("DD-MM-YYYYY");
		smp.format(dateObj);
		Calendar cal=smp.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		
		String reqdate=smp.format(cal.getTime());
		return reqdate;
	}
}

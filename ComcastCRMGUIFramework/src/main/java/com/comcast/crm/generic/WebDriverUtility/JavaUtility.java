package com.comcast.crm.generic.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	// method for random number
	public int getRandomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt(5000);
		return randomNum;
	}

	// method for current date
	public String getSystemDate() {

		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdf.format(dateObj);
		return currentDate;
	}

	// Method for required date
	public String getRequiredDate(int days) {

		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(dateObj);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate;
	}
}

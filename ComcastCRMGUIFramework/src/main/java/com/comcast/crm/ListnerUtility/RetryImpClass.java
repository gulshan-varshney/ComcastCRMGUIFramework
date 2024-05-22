package com.comcast.crm.ListnerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer {

	int count = 0;
	int limitCount = 5;
	public boolean retry(ITestResult result) {
		if (count < limitCount) {
			count++;
			return true;
		}
		return false;
	}

}

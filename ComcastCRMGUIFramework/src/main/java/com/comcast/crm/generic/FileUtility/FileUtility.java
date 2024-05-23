package com.comcast.crm.generic.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author gulshan
 *
 */
public class FileUtility {

	/**
	 * this method will read the data from property file
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertyFile(String key) throws IOException {

		FileInputStream fis = new FileInputStream("./ConfigAppData/CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		return data;
	}
}

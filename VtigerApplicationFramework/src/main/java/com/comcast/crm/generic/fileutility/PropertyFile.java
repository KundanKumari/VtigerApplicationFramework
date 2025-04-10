package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {
	
	public String getPropertyFileUtility(String key) throws Throwable {
		
		//Read common data from properties file
		FileInputStream fis = new FileInputStream("./src/main/resources/commondata.properties");
		
		Properties  pobj=new Properties();
		
		pobj.load(fis);
		
		String data=pobj.getProperty(key);
		
		return data;
	}

}

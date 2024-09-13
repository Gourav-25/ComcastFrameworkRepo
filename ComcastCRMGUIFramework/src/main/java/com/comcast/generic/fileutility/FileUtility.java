package com.comcast.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
    
	public String getDataFromPropertiesFile(String Key) throws Throwable {
		
		//Get the Java Representation Object for physical file
		FileInputStream fis=new FileInputStream("./configAppData/Commondata.properties");
		// load the key
		Properties prop=new Properties();
		prop.load(fis);
		//Read the data
		String data=prop.getProperty(Key);		
		return  data;
	}
}

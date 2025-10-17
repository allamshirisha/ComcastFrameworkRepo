package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getdataFromPropertiesFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("./ConfigAppData/cmdata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String data =pobj.getProperty(key);
		
		return data;
	}

}

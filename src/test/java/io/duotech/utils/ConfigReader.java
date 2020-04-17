package io.duotech.utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;
	static {
		try {
			String configFilePath = "config.properties";
			FileInputStream in = new FileInputStream(configFilePath);
			
			prop = new Properties();
			prop.load(in);
			in.close();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	

}

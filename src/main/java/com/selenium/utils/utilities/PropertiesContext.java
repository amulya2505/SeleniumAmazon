package com.selenium.utils.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesContext {
	private static final PropertiesContext propertiesContext = new PropertiesContext();
	private static Properties configProp;

	private PropertiesContext() {
		configProp = loadProperties("config.properties");
	}

	public static PropertiesContext getPropertiesContext() {
		return propertiesContext;
	}

	private static Properties loadProperties(String path) {
		Properties properties = new Properties();
		try {
			InputStream in = PropertiesContext.class.getClassLoader().getResourceAsStream(path);
			if (null == in) {
				in = new FileInputStream(path);
			}
			properties.load(in);
			System.out.println(path + " file loaded");
		} catch (Throwable t) {
			System.out.println("Error in reading properties file (" + path + ") : " + t.toString());
		}
		return properties;
	}

	public String getConfigProp(String key) {
		return configProp.getProperty(key);
	}
}

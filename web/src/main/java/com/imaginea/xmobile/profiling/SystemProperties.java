package com.imaginea.xmobile.profiling;

import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class SystemProperties {
	private static Properties properties;
	
	static {
		try {
			properties = PropertiesLoaderUtils.loadAllProperties("system.properties");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
			
	public static void setAndroidSdkPath(String sdkPath) {
		properties.put("ANDROID_SDK_HOME", sdkPath);
	}
	
	public static String getAndroidSdkPath() {
		return (String)properties.get("ANDROID_SDK_HOME");
	}
}

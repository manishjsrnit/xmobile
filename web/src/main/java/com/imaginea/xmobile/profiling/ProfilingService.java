package com.imaginea.xmobile.profiling;

import java.util.Map;

import com.imaginea.profiling.ADBCommand.ProfilingData;

public interface ProfilingService {

	public String[] showAllPackages();
	public int startProfiling(String packageName);
	public Map<String, ProfilingData> stopProfiling();
	boolean isDeviceConnected();
	void markAndroidPath(String androidSdkPath);
	
}

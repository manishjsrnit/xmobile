package com.imaginea.xmobile.profiling;


public interface ProfilingService {

	public String[] showAllPackages();
	public int startProfiling(String packageName);
	public ProfilingInfo stopProfiling();
	boolean isDeviceConnected();
	void markAndroidPath(String androidSdkPath);
	
}

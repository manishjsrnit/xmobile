package com.imaginea.xmobile.profiling;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.android.ddmlib.AndroidDebugBridge;
import com.imaginea.profiling.AndroidProfiler;
import com.imaginea.profiling.ADBCommand.ProfilingData;

@Component
public class ProfilingServiceImpl implements ProfilingService {
	private AndroidProfiler androidProfiler;
	
	public ProfilingServiceImpl() {
		androidProfiler = new AndroidProfiler(SystemProperties.getAndroidSdkPath(), "");
	}
	
	@Override
	public String showAllPackages() {
		return androidProfiler.showAllPackages();
	}

	@Override
	public int startProfiling(String packageName) {
		return androidProfiler.startUIPerformanceProfiler(packageName, true);
	}

	@Override
	public Map<String, ProfilingData> stopProfiling() {
		androidProfiler.stopProfiling();
		return androidProfiler.getProfilingMap();
	}
	
	@Override
	public boolean isDeviceConnected() {
		AndroidDebugBridge.initIfNeeded(false);
        AndroidDebugBridge debugBridge = AndroidDebugBridge.createBridge(SystemProperties.getAndroidSdkPath() +
        		 "/platform-tools/adb.exe", true);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
       return debugBridge.getDevices().length > 0;
	}

	@Override
	public void markAndroidPath(String androidSdkPath) {
		SystemProperties.setAndroidSdkPath(androidSdkPath);
		androidProfiler = new AndroidProfiler(SystemProperties.getAndroidSdkPath(), "");
	}
}

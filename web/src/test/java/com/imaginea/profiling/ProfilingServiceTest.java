package com.imaginea.profiling;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.imaginea.profiling.ADBCommand.ProfilingData;
import com.imaginea.xmobile.profiling.ProfilingServiceImpl;
import com.imaginea.xmobile.profiling.SystemProperties;


@RunWith(BlockJUnit4ClassRunner.class)
public class ProfilingServiceTest {
	private static ProfilingServiceImpl profilingService;

	@BeforeClass
	public static void preTest() {
		SystemProperties.setAndroidSdkPath("E:/adt-bundle-windows-x86_64-20140321/sdk");
		//profilingService = new ProfilingServiceImpl();
	}
	
	@Test
	public void isConnected() {
		//Assert.assertEquals(true, profilingService.isDeviceConnected());
	}

	//@Test
	public void showAllPackages() {
		String[] packages = profilingService.showAllPackages();
		Assert.assertFalse(packages.length == 0);
	}

	//@Test
	public void profile() throws InterruptedException {
		profilingService.startProfiling("com.whatsapp");
		Thread.sleep(30000);
		Map<String, ProfilingData> profilingMap = profilingService.stopProfiling();
		Set<Entry<String, ProfilingData>> profilingEntrySet = profilingMap.entrySet();
		final String leftAlignFormat = "| %-35s | %-28d | %-22d | %-20s | %-20s | %-10s  %n";
		for(Entry<String, ProfilingData> profilingItem : profilingEntrySet) {
			System.out.format(leftAlignFormat, profilingItem.getKey(),
					profilingItem.getValue().getLaunchTime(), profilingItem
					.getValue().getActivityStackCount(),
					profilingItem.getValue().getOverDraws(), profilingItem
					.getValue().getGCCalls()[1], profilingItem
					.getValue().getGCCalls()[0]);
		}
	}

	//@AfterClass
	public static void afterTest() {
	}
}

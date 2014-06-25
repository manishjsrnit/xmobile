package com.imaginea.xmobile.profiling;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.imaginea.profiling.ADBCommand.ProfilingData;

public class ProfilingInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, ProfilingData> profilingMap = new HashMap<String, ProfilingData>();
	private boolean appLaunchedFirstTime;
	private Map<String, String> activityGrades = new HashMap<String, String>();
	private int activityStackScore;
	private String applicationRating;
	private int applicationScore;
	private int gcScore;
	private int launchTimeScore;
	private int overDrawScore;
	
	public Map<String, String> getActivityGrades() {
		return activityGrades;
	}

	public boolean isAppLaunchedFirstTime() {
		return appLaunchedFirstTime;
	}

	public void setAppLaunchedFirstTime(boolean appLaunchedFirstTime) {
		this.appLaunchedFirstTime = appLaunchedFirstTime;
	}

	public Map<String, ProfilingData> getProfilingMap() {
		return profilingMap;
	}
	
	public void setProfilingMap(Map<String, ProfilingData> profilingMap) {
		this.profilingMap = profilingMap;
	}

	public void setActivityGrades(Map<String, String> activityGrades) {
		this.activityGrades = activityGrades;
	}

	public void setActivityStackScore(int activityStackScore) {
		this.activityStackScore = activityStackScore;
	}

	public int getActivityStackScore() {
		return activityStackScore;
	}

	public void setApplicationRating(String applicationRating) {
		this.applicationRating = applicationRating;
	}

	public String getApplicationRating() {
		return applicationRating;
	}

	public void setApplicationScore(int applicationScore) {
		this.applicationScore = applicationScore;
	}

	public void setGcScore(int gcScore) {
		this.gcScore = gcScore;
	}

	public void setLaunchTimeScore(int launchTimeScore) {
		this.launchTimeScore = launchTimeScore;
	}

	public void setOverDrawScore(int overDrawScore) {
		this.overDrawScore = overDrawScore;
	}

	public int getApplicationScore() {
		return applicationScore;
	}

	public int getGcScore() {
		return gcScore;
	}

	public int getLaunchTimeScore() {
		return launchTimeScore;
	}

	public int getOverDrawScore() {
		return overDrawScore;
	}

}

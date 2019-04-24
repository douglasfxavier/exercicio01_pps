package model;

import java.util.HashMap;
import java.util.Map;

public class Suite{

	private String name;
	private Map<SoftwareCategory, Software> apps;
	
	
	public Suite(String name) {
		super();
		this.name = name;
		this.apps = new HashMap<SoftwareCategory,Software>();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Map<SoftwareCategory, Software> getAllApps() {
		return apps;
	}
	
	public Software getAppByCategory(SoftwareCategory category) {
		return this.apps.get(category);
	}
	
	
	public void addSoftware(Software app) {
		this.apps.put(app.getCategory(), app);
	}
}

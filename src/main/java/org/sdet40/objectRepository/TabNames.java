package org.sdet40.objectRepository;

public enum TabNames {
	CONTACTS("Contacts"),  OPPORTUNITIES("Opportunities"), ORGANIZATION("Organizations"), 
	EMAIL("Email"),DASHBOARD("Dashboard"), 
	SIGNOUT("Sign Out"), CAMPAIGNS("Campaigns"), MORE("More");
	
	private String tabName;
	private TabNames(String tabName) {
		this.tabName=tabName;
	}
	
	public String getTabName() {
		return tabName;
	}
}



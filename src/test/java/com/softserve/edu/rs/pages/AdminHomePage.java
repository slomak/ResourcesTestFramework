package com.softserve.edu.rs.pages;


import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;
import com.softserve.edu.atqc.data.apps.PageObserveLoad;

public class AdminHomePage extends HomePage {

	private class AdminHomePageUIMap {
		public final ILink home;
		public final ILink users;
		public final ILink settings;
		public final ILink communities;
		public final ILink newUser;
		public final ILink unblockAll;
    	
    	public AdminHomePageUIMap() {
    		this.home = Link.get().getByCssSelector("a.glyphicon.glyphicon-home");
    		this.users = Link.get().getByXpath("//li[@class='dropdown']");
    		this.settings = Link.get().getByXpath("//a[contains(@href,'/settings')]");
    		this.communities = Link.get().getByXpath("//a[contains(@href,'/communities/show-all-communities')]");
    		this.newUser = Link.get().getByXpath("//a[contains(@href,'/manualregistration')]");
    		this.unblockAll = Link.get().getById("unlockUsers");
    	}
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private class StatusUsersPageUIMap {
		public final ILink active;
		public final ILink inactive;
		public final ILink nonConfirmed;
		public final ILink blocked;
		
		public StatusUsersPageUIMap() {
			this.active = Link.get().getByXpath("//ul/li[1]/a[contains(@href,'/users/get-all-users')]");
			this.inactive = Link.get().getByXpath("//a[contains(@href,'/users/get-all-users?statusType=inactive')]");
			this.nonConfirmed = Link.get().getByXpath("//a[contains(@href,'/users/get-all-users?statusType=notcomfirmed')]");
			this.blocked = Link.get().getByXpath("//a[contains(@href,'/users/get-all-users?statusType=block')]");
		}
		
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
    // Elements
	
    private AdminHomePageUIMap controls;
    private StatusUsersPageUIMap statusUsersControls;

    public AdminHomePage() {
    	PageObserveLoad.get().deleteLoadCompleteEvents();
    	controls = new AdminHomePageUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Get Elements

	public ILink getHome() {
		return this.controls.home;
	}

	public ILink getUsers() {
		return this.controls.users;
	}

	public ILink getSettings() {
		return this.controls.settings;
	}

	public ILink getCommunities() {
		return this.controls.communities;
	}

	public ILink getNewUser() {
		return this.controls.newUser;
	}

	public ILink getUnblockAll() {
		return this.controls.unblockAll;
	}

	public String getHomeText() {
		return getHome().getText();
	}

	public String getUsersText() {
		return getUsers().getText();
	}

	public String getSettingsText() {
		return getSettings().getText();
	}

	public String getCommunitiesText() {
		return getCommunities().getText();
	}

	public String getNewUserText() {
		return getNewUser().getText();
	}

	public String getUnblockAllText() {
		return getUnblockAll().getText();
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public ILink getActive() {
		clickUsers();
		return this.statusUsersControls.active;
	}
	
	public ILink getInactive() {
		clickUsers();
		return this.statusUsersControls.inactive;
	}
	
	public ILink getNonConfirmed() {
		clickUsers();
		return this.statusUsersControls.nonConfirmed;
	}
	
	public ILink getBlocked() {
		clickUsers();
		return this.statusUsersControls.blocked;
	}
	
	// Set Data
    
	public void setFocusUsers() {
		getUsers().setFocus();
	}

	public void clickHome() {
		getHome().click();
	}

	public void clickUsers() {
		setFocusUsers();
		statusUsersControls = new StatusUsersPageUIMap();
	}

	public void clickSettings() {
		getSettings().click();
	}

	public void clickCommunities() {
		getCommunities().click();
	}

	public void clickNewUser() {
		getNewUser().click();
	}

	public void clickUnblockAll() {
		getUnblockAll().click();
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public void clickActive() {
		getActive().click();
	}
	
	public void clickInactive() {
		getInactive().click();
	}
	
	public void clickNonConfirmed() {
		getNonConfirmed().click();
	}
	
	public void clickBlocked() {
		getBlocked().click();
	}

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Functional
	
    public AdminHomePage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        return new AdminHomePage();
    }
    
    public ActiveAdminSearchPage gotoActiveUsers() {
    	clickActive();
        return new ActiveAdminSearchPage();
    }

}

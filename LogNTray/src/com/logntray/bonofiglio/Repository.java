package com.logntray.bonofiglio;

import java.util.Map;

public class Repository {
	private APIFacade api;
	
	public Repository() {
		Map<String, String> config = (new JsonConfigParser()).parse();
		try {
			this.api = (APIFacade) Class.forName("com.logntray.bonofiglio." + config.get("api")).getConstructor().newInstance();
		}
		catch(Exception e) {
			e.printStackTrace();
			this.api = new NodeServerAPIAdapter();
		}
	}
	
	public boolean authenticate(String username, String password) {
		System.out.println("username: " + username);
		System.out.println("password: " + password);
        return api.login(username, password);
    }
	
	public void setStatus(String status) {
		api.setStatus(status);
	}
	
	public void logout() {
		api.logout();
	}

}

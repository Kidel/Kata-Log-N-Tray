package com.logntray.bonofiglio;

public class Repository {
	private APIAdapter api = new APIAdapter();
	
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

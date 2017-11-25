package com.logntray.bonofiglio;

public interface APIFacade {
	public boolean login(String username, String password);
	public boolean logout();
	public boolean setStatus(String status);
}

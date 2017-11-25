package com.logntray.bonofiglio;

import java.net.URISyntaxException;

public class ClassFilePathExtractor {
	public String getPath() {
    	try {
			return LogNTray.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return "";
		}
    }
}

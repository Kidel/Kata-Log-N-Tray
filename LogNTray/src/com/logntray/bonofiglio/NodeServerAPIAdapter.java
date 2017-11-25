package com.logntray.bonofiglio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class NodeServerAPIAdapter implements APIFacade {
	private WebClient wc;
	private String loginUrl;
	private String statusUrl;
	private String logoutUrl;

	public NodeServerAPIAdapter() {
		this.wc = new WebClient();
		Map<String, String> config = (new JsonConfigParser()).parse();
		
		// defaults
		this.loginUrl = "http://localhost:3000/api/login";
		this.statusUrl = "http://localhost:3000/api/updateStatus";
		this.logoutUrl = "http://localhost:3000/api/logoutUrl";
		
		if(config != null) {
			try {
				this.loginUrl = config.get("loginUrl");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				this.statusUrl = config.get("statusUrl");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				this.logoutUrl = config.get("logoutUrl");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean login(String username, String password) {
		String res = "";
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("email", username));
		params.add(new BasicNameValuePair("password", password));
		try {
			res = this.wc.sendPost(loginUrl, params);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		setStatus("2");
		
		JsonObject jsonObject = new JsonParser().parse(res).getAsJsonObject();
		return jsonObject.get("logged").getAsString().equals("true");
	}
	
	public boolean logout() {
		String res = "";
		try {
			res = this.wc.sendPost(logoutUrl, null);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		setStatus("0");
		
		JsonObject jsonObject = new JsonParser().parse(res).getAsJsonObject();
		return jsonObject.get("logged").getAsString().equals("false");
	}
	
	public boolean setStatus(String status) {
		if(status == "active") status = "2";
		if(status == "busy") status = "1";
		String res = "";
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("status", status));
		try {
			res = this.wc.sendPost(statusUrl, params);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		JsonObject jsonObject = new JsonParser().parse(res).getAsJsonObject();
		return jsonObject.get("status").getAsString().equals("ok");
	}
}

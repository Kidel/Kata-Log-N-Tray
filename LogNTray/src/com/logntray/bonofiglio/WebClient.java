package com.logntray.bonofiglio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
//import org.apache.http.cookie.Cookie;

public class WebClient {

	private static HttpClient httpClient = HttpClients.createDefault();
	private static CookieStore cookies = new BasicCookieStore();
	private static HttpContext httpContext = new BasicHttpContext();

	// HTTP POST request
	public String sendPost(String url, List<NameValuePair> params) {
		HttpPost httpPost = new HttpPost(url);
		if(params != null)
			try {
				httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		
		httpContext.setAttribute(HttpClientContext.COOKIE_STORE, cookies);
		
		//Execute and get the response.
		HttpResponse response;
		try {
			response = httpClient.execute(httpPost, httpContext);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String res = EntityUtils.toString(entity);
				System.out.println(res);
				
				/*// debug cookie informations
				for (Cookie cookie : cookies.getCookies()) {
					System.out.println(cookie.getName());
					System.out.println(cookie.getValue());
				}*/
				
				return res;
			}
		} catch (UnsupportedOperationException | IOException e1) {
			e1.printStackTrace();
		}
		return null;

	}

}
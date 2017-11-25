package com.logntray.bonofiglio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonConfigParser {
	public Map<String, String> parse() {
		try {
			String jsonString = readFile("config.json", StandardCharsets.UTF_8);
			return new Gson().fromJson(jsonString, new TypeToken<HashMap<String, String>>() {}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String readFile(String path, Charset encoding) 
			  throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
}

package com.logntray.bonofiglio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConfigParser {
	public JsonObject parse() {
		try {
			String content = readFile("config.json", StandardCharsets.UTF_8);
			return new JsonParser().parse(content).getAsJsonObject();
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

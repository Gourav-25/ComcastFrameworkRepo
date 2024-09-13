package com.comcast.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDataFromJsonFile(String Key) throws Throwable {
	//Parse the physical file into Java Object
	JSONParser parser=new JSONParser();
	Object obj=parser.parse(new FileReader("./configAppData/CommonData22.json"));
	//Convert the Java Object into Json Object
	JSONObject map=new JSONObject();
	//Read the Data
	String Data=map.get(Key).toString();
	return Data;
   }
}
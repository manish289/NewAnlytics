package com.isource.utility;

import org.json.simple.JSONValue;

import com.google.gson.Gson;

import io.swagger.v3.core.util.Json;

public class GenericConverter {

	public static String convertData(Object resultSetString){
		return  JSONValue.toJSONString(resultSetString);
	}

	// to convert in json format we want this method.
	public static String gsonToJson(Object resultSetString) {
		Gson gson = new Gson();
	return gson.toJson(resultSetString);
	}	

	
}
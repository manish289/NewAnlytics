package com.isource.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * PropertiesReader class is used to fetch all the properties file details and put it on hashmap <br/>
 * and used it through out the application.
 * @author 
 */
public class PropertiesReader {
	
	private static Map<String, Map<String, String>> propertiesMap;
		
	static {
		propertiesMap = new HashMap<String, Map<String, String>>();
		propertiesMap.put("constant", loadProperties("com/isource/properties/constant" ));
		propertiesMap.put("message", loadProperties("com/isource/properties/message" ));
	   }
	
	// the method is the  implementation of above loadPropperties. 
	public static Map<String, String> loadProperties(String fileName) {
		
		Map<String, String> queriesMap = new HashMap<String, String>();//  created new object for map to put the values.

		PropertiesReader pr = new PropertiesReader();
		Properties property = new Properties();
		try {
			property.load(pr.getClass().getClassLoader().getResourceAsStream(fileName + ".properties"));  //getResource method finds a resource of file with the specified name.
			
			for (Object key : property.keySet()) {
				queriesMap.put(key.toString(), property.get(key).toString());
			}                //key of properties file          //get message from that key.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return queriesMap;
	}

	
	public static String getProperty(String fileName, String key) {
		
		if (propertiesMap != null && propertiesMap.get(fileName) != null
				&& propertiesMap.get(fileName).get(key) != null)
			
			return propertiesMap.get(fileName).get(key);
		else
			return "";
	}
	
	
	
	
	
	
	
	
	
	
}
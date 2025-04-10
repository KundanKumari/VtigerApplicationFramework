package com.comcast.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONFile {

	public String getJsonData(String key) throws Throwable {

		FileReader fir = new FileReader("./configAppData/AppCommonData.json");

		JSONParser parser = new JSONParser();

		Object obj = parser.parse(fir);

		JSONObject map = (JSONObject) obj;

		String data = (String) map.get(key);

		return data;
	}

}

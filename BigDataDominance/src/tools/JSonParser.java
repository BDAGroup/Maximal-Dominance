package tools;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSonParser {

	public static void main(String[] args) {
		try {
	        JSONParser parser = new JSONParser();
	        //Use JSONObject for simple JSON and JSONArray for array of JSON.
	        JSONObject data;
			try {
				 data = (JSONObject) parser.parse(new FileReader("DataSet/zips.json"));
				 
				 String json = data.toJSONString();
				 System.out.println("Json " + json);
			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//path to the JSON file.

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

}
	

}

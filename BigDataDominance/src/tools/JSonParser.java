package tools;

 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;


public class JSonParser {
	
	public static String KEy = "AIzaSyCrC87vfVbf9r5LDWSCVAMc54TazyMQP9g";
	public static void main(String[] args) {
	
		NearByRestaurants(41.1536674 , -81.3578859 , "Mexican" , KEy);
	
	}
	 
	
	public static void NearByRestaurants(double lat , double longtitude , String cuisine , String key )
	{
		
		  JSONObject jsonObj = null;

        try {     
        	
        	String url  = "https://maps.googleapis.com/maps/api/place/nearbysearch/"
        			+ "json?location="+lat+","+longtitude+"&"+
        			"rankby=distance&types=restaurant&"
        			+"keyword="+cuisine+""
        					+ "&key="+key+"";
        	
        	System.out.println("Hello all! This is just for testing.");
            System.out.println(url);
        	
        	
            URL oracle = new URL(url);
            
            URLConnection yc = oracle.openConnection();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            
            String inputLine;
            
            StringBuilder stringBuilder = new StringBuilder();

            while ((inputLine = in.readLine()) != null) { 
            	   stringBuilder.append(inputLine);
            	   
            	   System.out.println("data" + String.valueOf(inputLine));
 
           }
     
            in.close();
            
            String ret = stringBuilder.toString();
            jsonObj = new JSONObject(ret);

            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  
	}
 
	
	public static void RestaurantsWithInRadius(double lat , double longtitude , String cuisine , String key , long radius)
	{
		
		JSONParser parser = new JSONParser();

        try {     
        	
        	String url  = "https://maps.googleapis.com/maps/api/place/radarsearch/"
        			+ "json?location="+lat+","+longtitude+"&radius="+radius+"&"+
        			"rankby=distance&types=restaurant&"
        			+"keyword="+cuisine+""
        					+ "&key="+key+"";
        	
            URL oracle = new URL(url);
            
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {  
            	
                System.out.println("JSON" +   inputLine);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } /*catch (ParseException e) {
            e.printStackTrace();
        }   
		*/
	}
	
	
	
	

}

package tools;

 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSonParser {
	
	public static String KEy = "AIzaSyCrC87vfVbf9r5LDWSCVAMc54TazyMQP9g";
	//41.1536674,-81.3578859

	public static void main(String[] args) {
	
		NearByRestaurants(41.1536674 , -81.3578859 , "Mexican" , KEy);
	
	}
	 
	
	public static void NearByRestaurants(double lat , double longtitude , String cuisine , String key )
	{
		
		JSONParser parser = new JSONParser();

        try {     
        	
        	String url  = "https://maps.googleapis.com/maps/api/place/nearbysearch/"
        			+ "json?location="+lat+","+longtitude+"&"+
        			"rankby=distance&types=restaurant&"
        			+"keyword="+cuisine+""
        					+ "&key="+key+"";
        	
            URL oracle = new URL(url);
            
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {  
            	
                System.out.println("JSON" +   inputLine);
                //JSONArray a = (JSONArray) parser.parse(inputLine);
               
               // System.out.println("Post ID : " +    a.toJSONString());
                
        
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
                //JSONArray a = (JSONArray) parser.parse(inputLine);
               
               // System.out.println("Post ID : " +    a.toJSONString());
                
        
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

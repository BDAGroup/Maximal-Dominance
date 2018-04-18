package tools;

 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import searchQuery.Restaurants;
import searchQuery.SkylineMain;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;


@SuppressWarnings("deprecation")
public class JSonParser {
	
	public static String KEy = "AIzaSyCrC87vfVbf9r5LDWSCVAMc54TazyMQP9g";
	private static HashMap<Integer , Vector<Object>> retreiveData ;
	private static Vector<String> resVec =  new Vector<String>(); 
	private static Vector<String> resPID =  new Vector<String>(); 
    public static Vector<Double[]> restuarantlatlng =  new Vector<Double[]>();
    public static Vector<Integer> restuarantPrice =  new Vector<Integer>();
	public static Vector<Double> restuarantScore =  new Vector<Double>();
	public static SkylineMain Skymain ;

	/**
	 * @return the restuarantPrice
	 */
	public static Vector<Integer> getRestuarantPrice() {
		return restuarantPrice;
	}


	/**
	 * @param restuarantPrice the restuarantPrice to set
	 */
	public static void setRestuarantPrice(Vector<Integer> restuarantPrice) {
		JSonParser.restuarantPrice = restuarantPrice;
	}



    /**
	 * @return the restuarantScore
	 */
	public static Vector<Double> getRestuarantScore() {
		return restuarantScore;
	}


	/**
	 * @param restuarantScore the restuarantScore to set
	 */
	public static void setRestuarantScore(Vector<Double> restuarantScore) {
		JSonParser.restuarantScore = restuarantScore;
	}


	/**
	 * @return the restuarantPrice
	 */
 

 
	/**
	 * @return the restuarantlatlng
	 */
	public static Vector<Double[]> getRestuarantlatlng() {
		return restuarantlatlng;
	}


	/**
	 * @param restuarantlatlng the restuarantlatlng to set
	 */
	public static void setRestuarantlatlng(Vector<Double[]> restuarantlatlng) {
		JSonParser.restuarantlatlng = restuarantlatlng;
	}


	public static Vector<String> getResPID() {
		return resPID;
	}

 
	public static void setResPID(Vector<String> resPID) {
		JSonParser.resPID = resPID;
	}


 
	public static Vector<String> getResVec() {
		return resVec;
	}

 
	public static void setResVec(Vector<String> resVec) {
		JSonParser.resVec = resVec;
	}
 
	
/*	public static String NearByRestaurants(double lat , double longtitude , String cuisine , String key )
	{
 
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
            
            StringBuilder stringBuilder = new StringBuilder();

            while ((inputLine = in.readLine()) != null) { 
            	   stringBuilder.append(inputLine);
 
           }
     
            in.close();
            
            String ret = stringBuilder.toString();
            return ret;
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  
        
        return null;
	}*/
 	
	public static HashMap<Integer , Vector<Object>> getData (String JsonResponse )
	{
		try{
				Skymain = new SkylineMain();
			  JSONObject obj_JSONObject = new JSONObject(JsonResponse.toString());
	           JSONArray results = obj_JSONObject.getJSONArray("results");
	           retreiveData =  new HashMap<Integer , Vector<Object>>();
	           for (int i = 0 ; i < results.length() ; i++)
	           {
	        	   try{
	        	    JSONObject jsonObject2 = (JSONObject)results.get(i);
	                JSONObject geometry = (JSONObject)jsonObject2.get("geometry");
	                JSONObject location = (JSONObject) geometry.get("location");
	                
	              
	                Double latitude = (Double)location.get("lat");
	                Double longitude = (Double)location.get("lng");
	                
	                String name = (String)jsonObject2.get("name").toString();
	                
	                String place_id = (String)jsonObject2.get("place_id").toString();
	                
	                JSONObject opening_hours = (JSONObject)jsonObject2.get("opening_hours");
	                
	                Boolean open = (Boolean)opening_hours.get("open_now");
	                int price_level = (int)jsonObject2.get("price_level");
	                double rating = (double)jsonObject2.get("rating");
	                Vector<Object> data = new Vector<Object>();
	                data.add(name);
	                Double[] geo  =  new Double[2];
	                geo[0] = latitude;
	                geo[1] = longitude;
	                data.add(geo);
	                data.add(open);
	                data.add(price_level);
	                data.add(rating);
	                resVec.addElement(name);
	                resPID.addElement(place_id);
	                retreiveData.put(i, data);
	                restuarantlatlng.addElement(geo);
	                restuarantPrice.addElement(price_level);
	                restuarantScore.addElement(rating);
	                setRestuarantlatlng(restuarantlatlng);
	                setRestuarantPrice(restuarantPrice);
	                setRestuarantScore(restuarantScore);

					 //double distance , double lat ,  double lng , int score ,  double price  , boolean chec

					   double dis =  tools.Tools.distance(41.1536674 , -81.3578859, latitude, longitude);
					   Restaurants re = new Restaurants(dis , latitude ,longitude ,  rating , price_level , true );

					   
					   Skymain.Init(re);

					   //SkylineMain.SortRestaurant();
 
	        	   }

	        	   catch(Exception e)
	        		{
	        			
	        		}
	        	   
	           }
	           Skymain.Skyline(Skymain.SortRestaurant());
	           
	           return retreiveData ;
		}
		catch(Exception e)
		{
			
			
		}
		
		return null;
	}
	
	
	@SuppressWarnings("resource")
	public static String RestaurantsWithInRadius (double lat , double longtitude , String cuisine , String key , double radius) throws ParseException, FileNotFoundException, IOException 
	{
		   InputStream inputStream = null;
           String json = "";

           try {           
               HttpClient client = new DefaultHttpClient(); 
               
               
               String url  = "https://maps.googleapis.com/maps/api/place/nearbysearch/"
        			+ "json?location="+lat+","+longtitude+"&radius="+radius*1609.34+"&&types=restaurant&"
        			+"keyword="+cuisine+""
        					+ "&key="+key+"";
               
               System.out.println("Url " + url);
               
               HttpPost post = new HttpPost(url);
               HttpResponse response = client.execute(post);
               HttpEntity entity = response.getEntity();
               inputStream = entity.getContent();
              
           } catch(Exception e) {
           }

           try {           
               BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"),8);
               StringBuilder sbuild = new StringBuilder();
               String line = null;
               while ((line = reader.readLine()) != null) {
                   sbuild.append(line);
               }
               inputStream.close();
               json = sbuild.toString();               
           } catch(Exception e) {
           }
          
           return json;
 
          
       }
 
}

/**
 * 
 */
package tools;

import java.text.DecimalFormat;

/**
 * @author Abhishek Singh
 *
 */
public class Tools {

	
	  public static double distance(double lat1, double lon1, double lat2, double lon2 ) {


          double theta = lon1 - lon2;
          double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
          dist = Math.acos(dist);
          dist = rad2deg(dist);
          dist = dist * 60 * 1.1515;
          return formatValueoTwoPlaces((dist*0.621371));
        }
	  
	  public static double deg2rad(double deg) {
          return (deg * Math.PI / 180.0);
        }
    public static double rad2deg(double rad) {
          return (rad * 180.0 / Math.PI);
        }
	
    
	public static Double formatValueoTwoPlaces(double value) {
		DecimalFormat myFormatter = new DecimalFormat("####0.00");
		return Double.parseDouble(myFormatter.format(value));
	}
	
	
	public static String GetChar(int i)
	{
/*		String str  = "0";
		switch(i)
		{
		case 0:	str = "0";
		break;
		
		case 1:	str = "$";
		break;	
		
		case 2:	str = "$$";
		break;	
		
		case 3:	str = "$$$";
		break;	
		
		case 4:	str = "$$$$";
		break;	
		
		case 5:	str = "$$$$$";
		break;	

		}*/
		
		return String.valueOf(i);
	}
	
}

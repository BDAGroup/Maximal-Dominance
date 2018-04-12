/**
 * 
 */
package searchQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MagnumES
 *
 */
public class SkylineAlgo {
	
	
	
	
	public static void main(String[] args)
	{
		
		//asodkas
		
		
		int[][] skyscraper = {
			    {2,9,10}, 
			    {3,6,15}, 
			    {5,12,12}, 
			    {13,16,10},
			    {15,17,5}
			  };
			   
			  List<int[]> listSkyline = getSkyline(0, skyscraper.length-1, skyscraper); 
			  for (int[] is : listSkyline) {
			   System.out.println(is[0] + "," + is[1] );
			  }
			  
			 }
			 
			 private static List<int[]> getSkyline(int low, int high, int[][] skyscraper) {
			  int mid = low + (high-low)/2;
			   
			  List<int[]> skyLineDiagonalPoints = new ArrayList<int[]>(); 
			  if (low > high){
			   return skyLineDiagonalPoints;
			   
			  }else if(low==high){
			   int[] point1 = new int[2];
			   point1[0] = skyscraper[low][0];
			   point1[1] = skyscraper[low][2];
			    
			   int[] point2 = new int[2];
			   point2[0] = skyscraper[low][1];
			   point2[1] = 0;
			    
			   skyLineDiagonalPoints.add(point1);
			   skyLineDiagonalPoints.add(point2);
			    
			   return skyLineDiagonalPoints;
			    
			  }else{
			   List<int[]> skyline1 = getSkyline(low, mid, skyscraper);
			   List<int[]> skyline2 = getSkyline(mid+1, high, skyscraper);
			   return mergeSkyLines(skyline1, skyline2);
			  }  
			 }
			 
			 private static List<int[]> mergeSkyLines(List<int[]> skyline1, List<int[]> skyline2) {
			   
			  List<int[]> mergedSkyLineDiagonalPoints = new ArrayList<int[]>();
			  int lastHeightSkyScraper1 = 0;
			  int lastHeightSkyScraper2 = 0;
			   
			  while( !(skyline1.isEmpty() || skyline2.isEmpty()) ){
			    
			   if(skyline1.get(0)[0] < skyline2.get(0)[0]){
			     
			    int maxHeight = skyline1.get(0)[1];
			    if(skyline1.get(0)[1] < lastHeightSkyScraper2){
			     maxHeight = lastHeightSkyScraper2;
			    }
			    lastHeightSkyScraper1 = skyline1.get(0)[1];
			    mergedSkyLineDiagonalPoints.add(new int[]{skyline1.get(0)[0], maxHeight});
			    skyline1.remove(0);
			     
			   }else if(skyline1.get(0)[0] > skyline2.get(0)[0]){
			     
			    int maxHeight = skyline2.get(0)[1];
			     
			    if(skyline2.get(0)[1] < lastHeightSkyScraper1){
			     maxHeight = lastHeightSkyScraper1;
			    }
			    lastHeightSkyScraper2 = skyline2.get(0)[1];
			    mergedSkyLineDiagonalPoints.add(new int[]{skyline2.get(0)[0], maxHeight});
			    skyline2.remove(0);
			     
			   }else{
			    int maxHeight = skyline1.get(0)[1] > skyline2.get(0)[1] ? skyline1.get(0)[1] : skyline2.get(0)[1]; 
			    mergedSkyLineDiagonalPoints.add( new int[]{skyline1.get(0)[0], maxHeight} );
			     
			    lastHeightSkyScraper1 = skyline1.get(0)[1];  
			    lastHeightSkyScraper2 = skyline2.get(0)[1]; 
			     
			    skyline1.remove(0);
			    skyline2.remove(0);
			   }
			  }
			   
			  while(!skyline1.isEmpty()){
			   mergedSkyLineDiagonalPoints.add( new int[]{skyline1.get(0)[0], skyline1.get(0)[1]} );
			   skyline1.remove(0);
			  }
			  while(!skyline2.isEmpty()){
			   mergedSkyLineDiagonalPoints.add( new int[]{skyline2.get(0)[0], skyline2.get(0)[1]} );
			   skyline2.remove(0);
			  }
			   
			  //Remove Points falling at same height
			  for (int i = 0; i < mergedSkyLineDiagonalPoints.size(); i++) {
			   int j = i+1;
			   while(j < mergedSkyLineDiagonalPoints.size() && mergedSkyLineDiagonalPoints.get(j)[1] == mergedSkyLineDiagonalPoints.get(i)[1]){
			    mergedSkyLineDiagonalPoints.remove(j);
			    j++;
			   }
			  }
			   
			  return mergedSkyLineDiagonalPoints;
			 }
			}
package searchQuery;

 
import java.util.Vector;

//import graphics.DrawGraph;
import graphics.MainGraphics;
import tools.XYLineChartExample;

public class SkylineMain
{
    public   Vector<Restaurants> RestaurantList   = new Vector<Restaurants>();
    public   Vector<Restaurants> Totalres   = new Vector<Restaurants>();
    public   Vector<Restaurants> sortres  ;
    public   Restaurants temp;
 
    public  void Init(Restaurants e)
    {
        RestaurantList.addElement(e);
    }
 
    public Vector<Restaurants> SortRestaurant()
    {

        for (int i = 0; i < RestaurantList.size()-1; i++)
        {
            for (int j = i + 1; j < RestaurantList.size(); j++)
            {

                if (RestaurantList.get(i).getDistance() > RestaurantList.get(j).getDistance())
                {
                	temp = RestaurantList.get(i);
                    RestaurantList.set(i , RestaurantList.get(j));
                    RestaurantList.set(j , temp);
 
                }
            }
  
        }
     
        return RestaurantList;

    }


   public Vector<Restaurants> Skyline(Vector<Restaurants> RestaurantList)
    {
        int i =0, j=0;
        
       Vector<Restaurants>  sortres = new Vector<Restaurants>();

       while (i <= RestaurantList.size())
        {
            for (j = i + 1; j < RestaurantList.size(); j++)   // this 2D loop is used for (distance,price), (distance,score), and (price, score)
            {
                if (( RestaurantList.get(j).getDistance() >= RestaurantList.get(i).getDistance()) 
                		&& (RestaurantList.get(j).getScore() >= RestaurantList.get(i).getScore()))
                {
                    RestaurantList.get(j).setCheck(false);                   
                }
            }
            i++;
        }
       
  
       
         for (i = 0; i < RestaurantList.size(); i++)
         {
            if (RestaurantList.get(i).isCheck())
            {
            	sortres.addElement(RestaurantList.get(i));
            }

        } 
       SetTotalRestaurant(RestaurantList);
       
       
       
       if (sortres.size() > 0)
       {
    	   
    	  
    	     
           for (int o = 0 ; o< sortres.size() ; o++)
           {
        	   	System.out.println("Sorted Res ->" + sortres.get(o).getDistance() 
        	   	+" | "+ sortres.get(o).getScore()   	+" | "+ sortres.get(o).isCheck());
           }
    	
    	   XYLineChartExample.DrawChart( "Distance", "Score", RestaurantList , sortres);
    	   System.out.println("RestaurantList " + RestaurantList.size());
    	   System.out.println("Sksz " + sortres.size());
       }

       //RestaurantList.removeAllElements();
       return sortres;
 
    }
   
   
   
   public void SetTotalRestaurant(Vector<Restaurants> res)
   {
	   Totalres = res;
   }
   
   public Vector<Restaurants> getTotalRestaurant()
   {
	   return Totalres;
   }

}

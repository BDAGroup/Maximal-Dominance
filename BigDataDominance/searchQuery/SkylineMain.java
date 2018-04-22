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
    /**
	 * @return the sortres
	 */
	public Vector<Restaurants> getSortres() {
		return sortres;
	}

	/**
	 * @param sortres the sortres to set
	 */
	public void setSortres(Vector<Restaurants> sortres) {
		this.sortres = sortres;
	}

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
    
    public Vector<Restaurants> SortRestaurant(int type)
    {

        for (int i = 0; i < RestaurantList.size()-1; i++)
        {
            for (int j = i + 1; j < RestaurantList.size(); j++)
            {

            	if(type == 2) {  if (RestaurantList.get(i).getDistance() > RestaurantList.get(j).getDistance())
                {
                	temp = RestaurantList.get(i);
                    RestaurantList.set(i , RestaurantList.get(j));
                    RestaurantList.set(j , temp);
 
                }}
            	else if(type == 3) {  if (RestaurantList.get(i).getDistance() > RestaurantList.get(j).getDistance())
                {
                	temp = RestaurantList.get(i);
                    RestaurantList.set(i , RestaurantList.get(j));
                    RestaurantList.set(j , temp);
 
                }}
            	
            	else if(type == 4) {  if (RestaurantList.get(i).getPrice() > RestaurantList.get(j).getPrice())
                {
                	temp = RestaurantList.get(i);
                    RestaurantList.set(i , RestaurantList.get(j));
                    RestaurantList.set(j , temp);
 
                }}
            }
  
        }
     
        return RestaurantList;

    }
    
    
    public Vector<Restaurants> Skyline(Vector<Restaurants> RestaurantList )
    {
        int i =0, j=0;
        
       Vector<Restaurants>  sortres = new Vector<Restaurants>();

       while (i < RestaurantList.size())
        {
            for (j = i + 1; j < RestaurantList.size(); j++)   // this 2D loop is used for (distance,price), (distance,score), and (price, score)
            {
            	 
            		if (( RestaurantList.get(j).getDistance() >= RestaurantList.get(i).getDistance()) 
                    		&& (RestaurantList.get(j).getPrice() >= RestaurantList.get(i).getPrice()))
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
       setSortres(sortres);
 
       //RestaurantList.removeAllElements();
       return sortres;
 
    }
    
    
    
    


   public Vector<Restaurants> Skyline(Vector<Restaurants> RestaurantList, int type)
    {
        int i =0, j=0;
        
       Vector<Restaurants>  sortres = new Vector<Restaurants>();

       while (i < RestaurantList.size())
        {
            for (j = i + 1; j < RestaurantList.size(); j++)   // this 2D loop is used for (distance,price), (distance,score), and (price, score)
            {
            	if(type == 2) {
            		if (( RestaurantList.get(j).getDistance() >= RestaurantList.get(i).getDistance()) 
                    		&& (RestaurantList.get(j).getPrice() >= RestaurantList.get(i).getPrice()))
                    {
                        RestaurantList.get(j).setCheck(false);                   
                    }
            	}
            	else if(type == 3) {
            		if (( RestaurantList.get(j).getDistance() >= RestaurantList.get(i).getDistance()) 
                    		&& (RestaurantList.get(j).getScore() >= RestaurantList.get(i).getScore()))
                    {
                        RestaurantList.get(j).setCheck(false);                   
                    }
            	}
            	
            	else if(type == 4) {
            		if (( RestaurantList.get(j).getPrice() >= RestaurantList.get(i).getPrice()) 
                    		&& (RestaurantList.get(j).getScore() >= RestaurantList.get(i).getScore()))
                    {
                        RestaurantList.get(j).setCheck(false);                   
                    }
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
       setSortres(sortres);
 
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

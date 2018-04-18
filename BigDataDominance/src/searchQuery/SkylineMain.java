package searchQuery;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashMap;
import java.util.Vector;

public class SkylineMain 
{


    public static Vector<Restaurants> RestaurantList   = new Vector<Restaurants>();
    public static Vector<Restaurants> sortres   = new Vector<Restaurants>();

    public static Restaurants temp;

    public static void Init(Restaurants e)
    {
        RestaurantList.addElement(e);
    }



    public static Vector<Restaurants> SortRestaurant()
    {


        for (int i = 0; i < RestaurantList.size()-1; i++)
        {
            for (int j = i + 1; j < RestaurantList.size(); j++)
            {

                if (RestaurantList.get(i).getDistance() > RestaurantList.get(j).getDistance())
                {
                    //System.out.println("disF: " + RestaurantList.get(i).getDistance());

                    //Restaurants temp = RestaurantList.get(i);

                	temp = RestaurantList.get(i);
                	
                    RestaurantList.set(i , RestaurantList.get(j));


                    RestaurantList.set(j , temp);

                    //System.out.println("disL: " + RestaurantList.get(i).getDistance());
                    //RestaurantList.setElementAt(RestaurantList.get(j),i);
                    //RestaurantList.setElementAt(temp,j);

                }
            }
            System.out.println("check: " + RestaurantList.get(i).isCheck());
        }
     
        return RestaurantList;

    }


   public static void Skyline(Vector<Restaurants> RestaurantList)
    {
        int i = 0, j;

       while (RestaurantList.get(i).isCheck() && i <= RestaurantList.size())
        {

            for (j = i + 1; j < RestaurantList.size(); j++)   // this 2D loop is used for (distance,price), (distance,score), and (price, score)
            {
                if ((RestaurantList.get(j).getDistance() >= RestaurantList.get(i).getDistance())
                        && (RestaurantList.get(j).getPrice() >= RestaurantList.get(i).getPrice()))
                {
                    RestaurantList.get(j).setCheck(false);
                    System.out.println("j : " +  j);
                    sortres.add(RestaurantList.get(i));
                }

            }
            i++;
            System.out.println("i : " +  i);
        }



       /* for (int x = 0; x < RestaurantList.size(); x++)
        {

            for (j = x + 1; j < RestaurantList.size(); j++)   // this 2D loop is used for (distance,price), (distance,score), and (price, score)
            {
                if ((RestaurantList.get(j).getDistance() >= RestaurantList.get(x).getDistance())
                        && (RestaurantList.get(j).getPrice() >= RestaurantList.get(x).getPrice()))
                {
                    RestaurantList.get(j).setCheck(false);

                    sortres.addElement(RestaurantList.get(x));
                }
            }

            System.out.println("x : " +  x);
        }*/

       // System.out.println("sortres : " +  sortres.size());
		/*for (j = i + 1; j < K; j++)   // this 3D loop is used for (distance,price,score)
		{
		if ((Restaurant[j].distance >= Restaurant[i].distance) && (Restaurant[j].price >= Restaurant[i].price) && (Restaurant[j].score >= Restaurant[i].score))
		Restaurant[j].check = false;
		}*/


         for (i = 0; i < RestaurantList.size(); i++)
        {
            if (RestaurantList.get(i).isCheck()==true)
            {
                System.out.println("Distance: " + RestaurantList.get(i).getDistance() + " Score: " + RestaurantList.get(i).getScore()
                        + " Lat: " + RestaurantList.get(i).getLat() +" Lon: " + RestaurantList.get(i).getLng() + " Price: "
                        + RestaurantList.get(i).getPrice());
            }

        }

    }

}

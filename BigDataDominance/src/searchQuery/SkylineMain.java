package searchQuery;

 
import java.util.Vector;

<<<<<<< HEAD
public class SkylineMain 
=======
public class SkylineMain
>>>>>>> refs/remotes/origin/master
{


    public   Vector<Restaurants> RestaurantList   = new Vector<Restaurants>();
    public   Vector<Restaurants> sortres  ;

<<<<<<< HEAD
    public   Restaurants temp;

    public   void Init(Restaurants e)
=======
    public static Restaurants temp;

    public static void Init(Restaurants e)
>>>>>>> refs/remotes/origin/master
    {
        RestaurantList.addElement(e);
    }



    public   Vector<Restaurants> SortRestaurant()
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
<<<<<<< HEAD
                	
=======

>>>>>>> refs/remotes/origin/master
                    RestaurantList.set(i , RestaurantList.get(j));


                    RestaurantList.set(j , temp);

                    //System.out.println("disL: " + RestaurantList.get(i).getDistance());
                    //RestaurantList.setElementAt(RestaurantList.get(j),i);
                    //RestaurantList.setElementAt(temp,j);

                }
            }
<<<<<<< HEAD
            //System.out.println("check: " + RestaurantList.get(i).isCheck());
=======
           // System.out.println("check: " + RestaurantList.get(i).isCheck());
>>>>>>> refs/remotes/origin/master
        }
     
        return RestaurantList;

    }


<<<<<<< HEAD
   public   void Skyline(Vector<Restaurants> RestaurantList)
=======
   public static void Skyline(Vector<Restaurants> RestaurantList)
>>>>>>> refs/remotes/origin/master
    {
<<<<<<< HEAD
        int i =0, j=0;
        
        sortres = new Vector<Restaurants>();
 
        while (RestaurantList.get(i).isCheck()==true && i <= RestaurantList.size())
=======
        int i = 0, j;

       while (RestaurantList.get(i).isCheck() && i <= RestaurantList.size())
>>>>>>> refs/remotes/origin/master
        {

            for (j = i + 1; j < RestaurantList.size(); j++)   // this 2D loop is used for (distance,price), (distance,score), and (price, score)
            {
                if ((RestaurantList.get(j).getScore() > RestaurantList.get(i).getScore())
                        && (RestaurantList.get(j).getPrice() > RestaurantList.get(i).getPrice())
                        /*&& RestaurantList.get(j).getDistance() > RestaurantList.get(i).getDistance()*/)
                {
                    RestaurantList.get(j).setCheck(false);
<<<<<<< HEAD
=======
                   // System.out.println("j : " +  j);
                    sortres.add(RestaurantList.get(i));
                }

            }
            i++;
           // System.out.println("i : " +  i);
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
>>>>>>> refs/remotes/origin/master
                }
            }
            i++;            
        } 

<<<<<<< HEAD
 
        System.out.println("RestaurantList : " + RestaurantList.size());
        for (i = 0; i < RestaurantList.size(); i++)
=======
            System.out.println("x : " +  x);
        }*/

       // System.out.println("sortres : " +  sortres.size());
		/*for (j = i + 1; j < K; j++)   // this 3D loop is used for (distance,price,score)
		{
		if ((Restaurant[j].distance >= Restaurant[i].distance) && (Restaurant[j].price >= Restaurant[i].price) && (Restaurant[j].score >= Restaurant[i].score))
		Restaurant[j].check = false;
		}*/


         for (i = 0; i < RestaurantList.size(); i++)
>>>>>>> refs/remotes/origin/master
        {
            if (RestaurantList.get(i).isCheck())
            {
<<<<<<< HEAD
              
                sortres.addElement(RestaurantList.get(i));
=======
            	sortres.addElement(RestaurantList.get(i));
            	
                System.out.println("Distance: " + RestaurantList.get(i).getDistance() + " Score: " + RestaurantList.get(i).getScore()
                        + " Lat: " + RestaurantList.get(i).getLat() +" Lon: " + RestaurantList.get(i).getLng() + " Price: "
                        + RestaurantList.get(i).getPrice());
>>>>>>> refs/remotes/origin/master
            }

        } 
        
       RestaurantList.removeAllElements();
       RestaurantList.setSize(0);
        
    	
        System.out.println("sortres : " + sortres.size());
        for (i = 0; i < sortres.size(); i++)
        {
                System.out.println("Distance: " + sortres.get(i).getDistance() + " Score: " + sortres.get(i).getScore()
                        + " Lat: " + sortres.get(i).getLat() +" Lon: " + sortres.get(i).getLng() + " Price: "
                        + sortres.get(i).getPrice());

<<<<<<< HEAD
        } 
        
        sortres.removeAllElements();

=======
>>>>>>> refs/remotes/origin/master
    }

}

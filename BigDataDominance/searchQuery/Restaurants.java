package searchQuery;

public class Restaurants {

    private   double distance;
    private   double lat;
    private   double lng;
    private   double score;
    private   double price;
    private   boolean check =true;
    private   int Kres;
    private   String Name;

    public Restaurants(double distance , double lat ,  double lng , double score ,  double price  , boolean check)
    {
        this.distance = distance;
        this.lat    = lat;
        this.lng    = lng;
        this.score  = score;
        this.price  = price;
        this.check  = check;
        
    }
    
    public Restaurants(String name , double distance , double lat ,  double lng , double score ,  double price  , boolean check)
    {
    	this.Name 	= name;
        this.distance = distance;
        this.lat    = lat;
        this.lng    = lng;
        this.score  = score;
        this.price  = price;
        this.check  = check;
        
    }
    
    public void setName(String name)
    {
    	this.Name = name;
    }
    
    public String getName()
    {
    	return this.Name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }



}

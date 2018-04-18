package searchQuery;

import java.util.Vector;

public class Restaurants {

    private   double distance = 0.0 ;
    private   double lat  = 0.0;
    private   double lng = 0.0;
    private   double score = -1.0;
    private   double price = 0.0;
    private   boolean check = true;
    private   int Kres = -1;

    public Restaurants(double distance , double lat ,  double lng , double score ,  double price  , boolean check)
    {
        this.distance = distance;
        this.lat    = lat;
        this.lng    = lng;
        this.score  = score;
        this.price  = price;
        this.check  = check;
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

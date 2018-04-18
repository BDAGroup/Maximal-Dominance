package searchQuery;

public class RestaurantParser {
	
	private String Restaurant;
	private String restaurant_id;
	private String Address;
	private String Cuisine;
	private long Zipcode;
	private char Grade;
	private int Score;
	private long Date;
	
	public RestaurantParser() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getRestaurant() {
		return Restaurant;
	}

	public void setRestaurant(String restaurant) {
		Restaurant = restaurant;
	}

	public String getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(String restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCuisine() {
		return Cuisine;
	}

	public void setCuisine(String cuisine) {
		Cuisine = cuisine;
	}

	public long getZipcode() {
		return Zipcode;
	}

	public void setZipcode(long zipcode) {
		Zipcode = zipcode;
	}

	public char getGrade() {
		return Grade;
	}

	public void setGrade(char grade) {
		Grade = grade;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public long getDate() {
		return Date;
	}

	public void setDate(long date) {
		Date = date;
	}





}

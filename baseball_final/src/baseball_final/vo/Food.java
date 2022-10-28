package baseball_final.vo;

public class Food {
	
	private int foodnum;
	private String team;
	private String category;
	private String restaurant;
	private String address;
	private String oneline;
	private double lat;
	private double lng;
	private String writer;
	private String writernick;
	
	public Food() {		}
	
	public Food(int foodnum, String team, String category, String restaurant, String address, String oneline, double lat, double lng, String writer, String writernick) {
		this.foodnum = foodnum;
		this.team = team;
		this.category = category;
		this.restaurant = restaurant;
		this.address = address;
		this.oneline = oneline;
		this.lat = lat;
		this.lng = lng;
		this.writer = writer;
		this.writernick = writernick;
	}

	public int getFoodnum() {
		return foodnum;
	}

	public void setFoodnum(int foodnum) {
		this.foodnum = foodnum;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOneline() {
		return oneline;
	}

	public void setOneline(String oneline) {
		this.oneline = oneline;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriternick() {
		return writernick;
	}

	public void setWriternick(String writernick) {
		this.writernick = writernick;
	}
	
}

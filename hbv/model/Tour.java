package hbv.model;


import java.util.ArrayList;



// TODO implement comparable
public class Tour implements Comparable<Tour>{

	private static final long serialVersionUID = 1L;
	private final String name;
	private final String description;
	private int seatsAvailable;
	private final String date;
	private final int price;
	private final int duration;
	private final String destination;
	private float rating;
	private int numberOfRatings;
	private final String departureLocation;
	private final String type;
	private final ArrayList<Guide> guides;
	private final ArrayList<TourReview> reviews;
        private final boolean pickup;
	private boolean rated;
        private int userRating;
        
	public Tour(String name, String description, int seatsAvailable, String date,
			int duration, float rating, int numberOfRatings, int price, String destination, 
			String departureLocation, String type, boolean pickup){
		this.name = name;
		this.description = description;
		this.seatsAvailable = seatsAvailable;
		this.date = date;
		this.duration = duration;
		this.rating = rating;
		this.numberOfRatings = numberOfRatings;
		this.price = price;
		this.departureLocation = departureLocation;
		this.type = type;
		this.destination = destination;
		this.pickup = pickup;
                                
		// Lazy loading
		guides = new ArrayList<>();
		reviews = new ArrayList<>();
                
                this.rated = false;
                this.userRating = 0;
	}
	
	public void setGuide(Guide guide){
		guides.add(guide);
	}
        
        public void setRated(){
            rated = true;
        }
        
        public boolean isRated(){
            return rated;
        }
        
        public void setUserRating(int userRating){
            this.userRating = userRating;
        }
	
        public int getUserRating(){
            return this.userRating;
        }
        
	public ArrayList<Guide> getGuides(){
		return guides;
	}
	
	
	public void setReviews(TourReview review){
		reviews.add(review);
	}
	
        public void clearReviews(){
            reviews.clear();
        }
        
        public void clearGuides() {
            guides.clear();
        }
	
	public ArrayList<TourReview> getReviews(){
	     return reviews;
	}
	
	public void bookSeats(int bookedSeats){
		this.seatsAvailable -= bookedSeats;
	}
	
	public void updateRating(float rating, int numberOfRatings){
		this.numberOfRatings = numberOfRatings;
		this.rating = rating;
		
	}
	
	public String getName(){
		return this.name;
	}
	public String getDescription(){
		return this.description;
	}
	public int getSeatsAvailable(){
		return this.seatsAvailable;
	}
	public int getPrice(){
		return this.price;
	}
	public String getDate(){
		return this.date;
	}
	public int getRating(){
		return (Math.round(rating));
	}
	public String getLocation(){
		return this.destination;
	}
	public int getDuration(){
		return this.duration;
	}
	
	public int getNumberOfRatings(){
		return this.numberOfRatings;
	}
	
	public String getDestination(){
		return this.destination;
	}
	
	public String getDepartureLocation(){
		return this.departureLocation;
	}

	public String getType() {
		return this.type;
	}
        
        public boolean getPickup(){
            return this.pickup;
        }
        
        @Override
        public String toString(){
            return this.name;
        }
        
        
        @Override
	public int compareTo(Tour other) {
		return this.getName().compareTo(other.getName());
	}	
                
}
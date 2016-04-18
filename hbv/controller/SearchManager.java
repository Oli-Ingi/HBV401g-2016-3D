package hbv.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Date;


import hbv.model.*;

public class SearchManager {

	
	private static ArrayList<Tour> tours = new ArrayList<Tour>();
	
	/*
	 * Database interaction methods :
	 */
        // Too many parameters for it to be sensible to overload this method.
        // use Integer and Float objects instead of int and float primitives to simplify checks
        // for each parameter. (just check if everything is null instead of f.ex. -1 for ints)
	public static ArrayList<Tour> createList(Integer priceLower,Integer priceHigher,Integer durationLower,Integer durationHigher,
			Date dateLower, Date dateHigher,Integer minAvailableSeats,String destination,String departure,
			String type, Integer rating, boolean hotelPickup, String name) throws NoSuchElementException{
		
		/*
		 * Búum til hakkatöflu, searchParams, sem mun geyma leitarskilyrðin frá notanda.
		 * Geymum skilyrðin á þannig formi að skilyrðið sem parameterinn skal uppfylla
		 * er lykillinn að parametrinum sjálfum.
		 */
		HashMap<String,Object> searchParams = new HashMap<>();
		if(priceLower!=null) searchParams.put("Price>=", priceLower);
		if(priceHigher!=null) searchParams.put("Price<=", priceHigher);
		if(durationLower!=null) searchParams.put("Duration>=", durationLower);
		if(durationHigher!=null) searchParams.put("Duration<=", durationHigher);
		if(dateLower!=null) searchParams.put("Date>=", new java.sql.Date(dateLower.getTime()));
		if(dateHigher!=null) searchParams.put("Date<=", new java.sql.Date(dateHigher.getTime()));
		if(minAvailableSeats!=null) searchParams.put("SeatsAvailable>=", minAvailableSeats);
                if(rating!=null) searchParams.put("rating >=", rating-0.5); // Because of rounding on tour objects.
                if(hotelPickup==true) searchParams.put("HotelPickup=", 1);
		if(!destination.equals("")) searchParams.put("Destination LIKE ", destination);
		if(!departure.equals("")) searchParams.put("Departure LIKE ", departure);
		if(!type.equals("")) searchParams.put("Type=", type);
		if(!name.equals("")) searchParams.put("Name LIKE ", name);
		
		
		// Bý til lista af Tour hlutum miðað við leitarskilyrðin.
		String[][] dbData = DBManager.getData("*","Tours",searchParams);
                
		// hreinsa gömlu leitarniðurstöðurnar úr tours (ef einhverjar eru).
		tours.clear();
		// Bý til Tour-hluti í samræmi við leitarniðurstöður og set í listann tours.
		for(int i=0; i<dbData.length;i++){
                    boolean val;
                    if(dbData[i][11].equals("1")) val = true;
                    else val = false;
                        tours.add(new Tour(dbData[i][0],dbData[i][1],Integer.valueOf(dbData[i][2]),dbData[i][3],
				Integer.valueOf(dbData[i][4]),Float.valueOf(dbData[i][5]),Integer.valueOf(dbData[i][6]),
				Integer.valueOf(dbData[i][7]),dbData[i][8],dbData[i][9],dbData[i][10],val));
		}
		return tours;
	}
	
	public static void bookTourSeats(String tourName, int bookedSeats) throws NoSuchElementException, IllegalArgumentException{

		// Byrjum að athuga núverandi sætafjölda.
		HashMap<String,Object> whereParams = new HashMap<>();
		whereParams.put("Name=", tourName);
		String[][] seatData = DBManager.getData("SeatsAvailable", "Tours", whereParams);
		int seats = Integer.parseInt(seatData[0][0]);
		if(bookedSeats<0) throw new IllegalArgumentException("Second input parameter must be positive.");
		
		// Lækkum sætafjöldann til að tákna að bókun hafi átt sér stað að því gefnu að nægilegt sætamagn sé í boði.
		if(seats>bookedSeats){
			DBManager.updateData("Tours", "SeatsAvailable", String.valueOf(seats-bookedSeats), whereParams);
		} else throw new IllegalArgumentException("Too few seats available.");
		
		// Ef að túrinn er í núverandi tours lista, update-um við hann líka.
		for(Tour tour: tours){
			if(tour.getName().equals(tourName)){
				tour.bookSeats(bookedSeats);
			}
		}
	}
	
	public static void updateRating(String tourName, int newRating) throws NoSuchElementException, IllegalArgumentException{

		if(newRating<0 || newRating>5) throw new IllegalArgumentException("Rating is on scale from 0 to 5, inclusive.");
		// Sækjum fjölda einkunnagjafa og núverandi einkunn.
		HashMap<String,Object> whereParams = new HashMap<String,Object>();
		whereParams.put("Name=", tourName);
		String[][] RatingData = DBManager.getData("NumberOfRatings, Rating", "Tours", whereParams);
		int amountOfRatings = Integer.parseInt(RatingData[0][0]);
		float oldRating = Float.parseFloat(RatingData[0][1]);
		
		// Reiknum út nýju einkunnina
		int expanded = (int)(oldRating*amountOfRatings)+newRating;
		amountOfRatings++;
		float rating = (float)expanded/amountOfRatings;
		
		// Skrifum fjölda einkunna ásamt nýju einkunninni í gagnagrunninn.
		DBManager.updateData("Tours", "NumberOfRatings", String.valueOf(amountOfRatings), whereParams);
		DBManager.updateData("Tours", "Rating", String.valueOf(rating), whereParams);
		
		// Uppfærum túrinn ef hann er í núverandi lista.
		for(Tour tour: tours){
			if(tour.getName()==tourName){
				tour.updateRating(rating, amountOfRatings);
			}
		}
	}
        
        public static void loadGuides(Tour tour){
            HashMap<String,Object> whereParams = new HashMap<>();
            whereParams.put("Name=", tour.getName());
            String[][] tourData = DBManager.getData("Guide1,Guide2,Guide3", "Tours", whereParams);
            
            for (int i = 0; i<tourData[0].length;i++) {
                if (tourData[0][i] != null) {
                    whereParams.clear();
                    whereParams.put("NickName=", tourData[0][i]);
                    String[][] guideData = DBManager.getData("*", "Guides", whereParams);
                    for(int j = 0; j<guideData.length;j++){
                        tour.setGuide(new Guide(guideData[j][0],guideData[j][1],Integer.parseInt(guideData[j][2]),guideData[j][3],guideData[j][4]));
                    }
                }
            }
        }
        
        public static void addTourReview(String tourName, String writter, String reviewText, Date writtenDate){
            HashMap<String, Object> insertParams = new HashMap<>();
            insertParams.put("Name", tourName);
            insertParams.put("ReviewTxt", reviewText);
            insertParams.put("Writter", writter);
            insertParams.put("WrittenDate", writtenDate);
            
            DBManager.insertData("TourReviews", insertParams);
        }
        
         public static void addGuideReview(String tourName, String writter, String reviewText, Date writtenDate){
            HashMap<String, Object> insertParams = new HashMap<>();
            insertParams.put("Name", tourName);
            insertParams.put("ReviewTxt", reviewText);
            insertParams.put("Writter", writter);
            insertParams.put("WrittenDate", writtenDate);
            
            DBManager.insertData("TourReviews", insertParams);
        }
	/*
	 * End of database interaction methods.
	 */
	
	/*
	 * Sorting methods :
	 */
	public static ArrayList<Tour> sortByName(){
		Collections.sort(tours);
		return tours;
	}
	public static ArrayList<Tour> sortByPrice(){
		Collections.sort(tours, new Comparator<Tour>(){
			@Override
			public int compare(Tour tour1, Tour tour2) {
				return tour1.getPrice()-tour2.getPrice();
			}
		});
		return tours;
	}
	public static ArrayList<Tour> sortByRating(){
		Collections.sort(tours, new Comparator<Tour>(){
			@Override
			public int compare(Tour tour1, Tour tour2) {
				if(tour1.getRating()>tour2.getRating()) return 1;
				else if(tour1.getRating()<tour2.getRating()) return -1;
				else return 0;
			}
		});
		return tours;
	}
	public static ArrayList<Tour> sortByDate(){
		Collections.sort(tours, new Comparator<Tour>(){
			@Override
			public int compare(Tour tour1, Tour tour2) {
				return tour1.getDate().compareTo(tour2.getDate());
			}
		});
		return tours;
	}
    public static ArrayList<Tour> sortByType(){
		Collections.sort(tours, new Comparator<Tour>(){
			@Override
			public int compare(Tour tour1, Tour tour2) {
				return tour1.getType().compareTo(tour2.getType());
			}
		});
		return tours;
	}
    /*
     * End of sorting methods
     */
    
    
	/*
	 * Testing methods : (only for unit testing)
	 */
    public static boolean isToursEmpty(){
        return false;
    }
	public static ArrayList<Tour> getTours(){
		return tours;
	}
	/*
	 * End of testing methods.
	 */
	
	
}
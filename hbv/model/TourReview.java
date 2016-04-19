package hbv.model;


public class TourReview extends Review{

	public TourReview(String review, String writer, String date){
		this.reviewText = review;
		this.writer = writer;
		this.dateOfWriting = date;
	}
}
